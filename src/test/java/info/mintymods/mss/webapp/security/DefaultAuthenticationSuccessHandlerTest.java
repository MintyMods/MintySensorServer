package info.mintymods.mss.webapp.security;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.security.core.Authentication;

import info.mintymods.mss.webapp.domain.Account;
import info.mintymods.mss.webapp.domain.Role;
import info.mintymods.mss.webapp.domain.SecureAccount;
import info.mintymods.mss.webapp.security.DefaultAuthenticationSuccessHandler;
import info.mintymods.mss.webapp.service.AccessHistoryService;
import info.mintymods.mss.webapp.service.AccountService;

public class DefaultAuthenticationSuccessHandlerTest {
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	@InjectMocks
	public DefaultAuthenticationSuccessHandler defaultAuthenticationSuccessHandler = new DefaultAuthenticationSuccessHandler();
	@Mock
	private AccountService accountService;
	@Mock
	private AccessHistoryService accessHistoryService;
	@Mock
	private HttpServletRequest request;
	@Mock
	private HttpServletResponse response;
	@Mock
	private Authentication authentication;
	private String username = "user";
	private String password = "password";
	private String invalidUsername = "invalid";
	private SecureAccount userDetails;
	private List<Role> roles;

	@Before
	public void before() {
		Role role = new Role();
		role.setRoleName("ADMIN");
		roles = new ArrayList<>();
		roles.add(role);
		Account account = new Account();
		account.setUserId(username);
		account.setPassword(password);
		account.setRoles(roles);
		userDetails = new SecureAccount(account);
		when(authentication.getPrincipal()).thenReturn(userDetails);
	}

	@Test
	public void onAuthenticationSuccess() throws Exception {
		defaultAuthenticationSuccessHandler.onAuthenticationSuccess(request, response, authentication);
		verify(accountService).processLoginSuccess(userDetails.getAccount());
	}
}
