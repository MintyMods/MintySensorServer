// Generated by delombok at Sat Jun 15 00:54:48 BST 2019
package info.mintymods.mss.webapp.service.impl;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import info.mintymods.mss.webapp.domain.AccessHistory;
import info.mintymods.mss.webapp.domain.Account;
import info.mintymods.mss.webapp.domain.Role;
import info.mintymods.mss.webapp.domain.SecureAccount;
import info.mintymods.mss.webapp.exception.AdminRoleNotFoundException;
import info.mintymods.mss.webapp.exception.PasswordEmptyException;
import info.mintymods.mss.webapp.repository.AccessHistoryRepository;
import info.mintymods.mss.webapp.repository.AccountRepository;
import info.mintymods.mss.webapp.repository.AccountRoleRepository;
import info.mintymods.mss.webapp.service.MessageSourceService;
import info.mintymods.mss.webapp.service.impl.AccountServiceImpl;

public class AccountServiceImplTest {
	private static final Logger log = LoggerFactory.getLogger(AccountServiceImplTest.class);
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	@InjectMocks
	public AccountServiceImpl accountService = new AccountServiceImpl();
	@Mock
	private AccountRepository accountRepository;
	@Mock
	private AccountRoleRepository accountRoleRepository;
	@Mock
	private AccessHistoryRepository accessHistoryRepository;
	@Mock
	private MessageSourceService messageSourceService;
	@Spy
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	private Account account;
	private Long id = 1L;
	private String userId = "userId";
	private String name = "name";
	private String password = "password";
	private String email = "test@test.com";
	private Role role;
	private String roleName = info.mintymods.mss.webapp.enums.Role.ROLE_ADMIN.getName();

	@Before
	public void before() {
		account = new Account();
		account.setId(id);
		account.setUserId(userId);
		account.setName(name);
		account.setPassword(password);
		account.setEmail(email);
		role = new Role();
		role.setId(id);
		role.setRoleName(roleName);
		List<Role> roles = new ArrayList<>();
		roles.add(role);
		account.setRoles(roles);
	}

	@Test
	public void testLoadUserByUsername() {
		when(accountRepository.findAccountByUserId(userId)).thenReturn(account);
		UserDetails userDetails = accountService.loadUserByUsername(userId);
		log.debug("userDetails : {}", userDetails);
		assertThat("Unexpected value.", userDetails, instanceOf(SecureAccount.class));
		assertThat("Unexpected value.", userDetails.getUsername(), is(userId));
		assertThat("Unexpected value.", userDetails.getPassword(), is(password));
		assertThat("Unexpected value.", userDetails.getAuthorities(), notNullValue());
		assertThat("Unexpected value.", userDetails.getAuthorities().size(), is(account.getRoles().size()));
		assertThat("Unexpected value.", userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN")),
				is(true));
	}

	@Test(expected = UsernameNotFoundException.class)
	public void testLoadUserByUsernameThrowsUserNameNotFoundException() {
		when(accountRepository.findAccountByUserId(userId)).thenReturn(account);
		accountService.loadUserByUsername(null);
	}

	@Test
	public void testAccount() {
		when(accountRepository.findAccountByUserId(userId)).thenReturn(account);
		Account expectedAccount = accountService.getAccount(userId);
		assertThat("Unexpected value.", expectedAccount, is(account));
	}

	@Test
	public void testInsertAdmin() {
		when(accountRoleRepository.findByRoleName(info.mintymods.mss.webapp.enums.Role.ROLE_ADMIN.getName()))
				.thenReturn(role);
//		when(accountRepository.save(argThat(new ArgumentMatcher<Account>() {
//			@Override
//			public boolean matches(Account account) {
//				if (passwordEncoder.matches(password, account.getPassword()) && account.getPasswordFailureCount() == 0 && account.getPasswordUpdatedDate() != null && account.getActivatedDate() != null && account.isActivated()) {
//					return true;
//				}
//				return false;
//			}
//		}))).thenReturn(account);
		Account expectedAccount = accountService.insertAdmin(account);
//		assertThat("Unexpected value.", expectedAccount, is(account));
	}

	@Test(expected = PasswordEmptyException.class)
	public void testInsertAdminWithEmptyPassword() {
		account.setPassword(null);
		when(accountRoleRepository.findByRoleName(info.mintymods.mss.webapp.enums.Role.ROLE_ADMIN.getName()))
				.thenReturn(role);
		accountService.insertAdmin(account);
	}

	@Test(expected = AdminRoleNotFoundException.class)
	public void testInsertAdminShouldReturnAdminRoleNotFoundException() {
		when(accountRoleRepository.findByRoleName(info.mintymods.mss.webapp.enums.Role.ROLE_ADMIN.getName()))
				.thenReturn(null);
		accountService.insertAdmin(account);
	}

	@Test
	public void testGetCount() {
		when(accountRepository.count()).thenReturn(1L);
		long count = accountService.getCount();
		assertThat("Unexpected value.", count, is(1L));
	}

	@Test
	public void testUpdate() {
		when(accountRepository.save(account)).thenReturn(account);
		Account expectedAccount = accountService.update(account);
		assertThat("Unexpected value.", account, is(expectedAccount));
	}

	@Test
	public void testProcessLoginSuccess() throws Exception {
		account.setPasswordFailureCount(1);
		accountService.processLoginSuccess(account);
//		verify(accessHistoryRepository).save(argThat(accessHistory -> validateAccountHistoryWhenLoginSucceded(accessHistory)));
//		verify(accountRepository).save(argThat(account -> validateAccountWhenLoginSucceded(account)));
	}

	private boolean validateAccountHistoryWhenLoginSucceded(AccessHistory accessHistory) {
		return accessHistory.getAccount() == account && accessHistory.isLoggedIn();
	}

	private boolean validateAccountWhenLoginSucceded(Account account) {
		return account.getLastLogin() != null && account.getPasswordFailureCount() == 0;
	}
}
