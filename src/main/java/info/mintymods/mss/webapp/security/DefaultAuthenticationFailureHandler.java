package info.mintymods.mss.webapp.security;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.ExceptionMappingAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import info.mintymods.mss.webapp.domain.AccessHistory;
import info.mintymods.mss.webapp.domain.Account;
import info.mintymods.mss.webapp.service.AccessHistoryService;
import info.mintymods.mss.webapp.service.AccountService;

@Component
public class DefaultAuthenticationFailureHandler extends ExceptionMappingAuthenticationFailureHandler {

	private static final String BAD_CREDENTIAL_EXCEPTION_URL = "/login/form?error=true&type=1";
	private static final String CREDENTIALS_EXPIRED_EXCEPTION_URL = "/login/form?error=true&type=2";
	private static final String ACCOUNT_EXPIRED_EXCEPTION_URL = "/login/form?error=true&type=3";
	private static final String LOCKED_EXCEPTION_URL = "/login/form?error=true&type=4";

	@Autowired
	private AccountService accountService;

	@Autowired
	private AccessHistoryService accessHistoryService;

	@Value("${account.password.failure.max.count:5}")
	private int passwordFailureMaxCount;

	@PostConstruct
	public void init() {
		Map<String, String> failureUrlMap = new HashMap<>();
		failureUrlMap.put(BadCredentialsException.class.getName(), BAD_CREDENTIAL_EXCEPTION_URL);
		failureUrlMap.put(CredentialsExpiredException.class.getName(), CREDENTIALS_EXPIRED_EXCEPTION_URL);
		failureUrlMap.put(AccountExpiredException.class.getName(), ACCOUNT_EXPIRED_EXCEPTION_URL);
		failureUrlMap.put(LockedException.class.getName(), LOCKED_EXCEPTION_URL);
		setExceptionMappings(failureUrlMap);
	}

	@Override
	@Transactional
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authenticationException) throws IOException, ServletException {
		String userId = request.getParameter("id");
		Account account = accountService.getAccount(userId);
		if (authenticationException instanceof BadCredentialsException) {
			processBadCredential(account, authenticationException);
		} else
			if (authenticationException instanceof CredentialsExpiredException) {
				processException(account, authenticationException);
			} else
				if (authenticationException instanceof LockedException) {
					processException(account, authenticationException);
				} else
					if (authenticationException instanceof AccountExpiredException) {
						processException(account, authenticationException);
					}
		super.onAuthenticationFailure(request, response, authenticationException);
		saveException(request, authenticationException);
	}

	private void processException(Account account, AuthenticationException authenticationException) {
		AccessHistory accessHistory = new AccessHistory();
		accessHistory.setAccount(account);
		accessHistory.setLoggedIn(false);
		accessHistory.setLoginDate(LocalDateTime.now());
		accessHistory.setComment(authenticationException.getMessage());
		accessHistoryService.insert(accessHistory);
	}

	private void processBadCredential(Account account, AuthenticationException authenticationException) {
		if (account != null) {
			processException(account, authenticationException);
			if (account.getPasswordFailureCount() >= passwordFailureMaxCount && !account.isLocked()) {
				account.setLocked(true);
			}
			account.setPasswordFailureCount(account.getPasswordFailureCount() + 1);
			accountService.update(account);
		}
	}
}
