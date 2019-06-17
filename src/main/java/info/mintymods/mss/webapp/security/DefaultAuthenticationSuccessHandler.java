package info.mintymods.mss.webapp.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import info.mintymods.mss.webapp.domain.SecureAccount;
import info.mintymods.mss.webapp.service.AccessHistoryService;
import info.mintymods.mss.webapp.service.AccountService;

@Component
public class DefaultAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	@Autowired
	private AccountService accountService;

	@Autowired
	private AccessHistoryService accessHistoryService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Authentication authentication) throws IOException, ServletException {
		SecureAccount secureAccount = (SecureAccount) authentication.getPrincipal();
		accountService.processLoginSuccess(secureAccount.getAccount());
		super.onAuthenticationSuccess(httpServletRequest, httpServletResponse, authentication);
	}

}
