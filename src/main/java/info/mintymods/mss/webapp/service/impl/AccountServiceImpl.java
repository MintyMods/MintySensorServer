package info.mintymods.mss.webapp.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import info.mintymods.mss.webapp.domain.AccessHistory;
import info.mintymods.mss.webapp.domain.Account;
import info.mintymods.mss.webapp.domain.Role;
import info.mintymods.mss.webapp.domain.SecureAccount;
import info.mintymods.mss.webapp.enums.MessageKey;
import info.mintymods.mss.webapp.exception.AdminRoleNotFoundException;
import info.mintymods.mss.webapp.exception.PasswordEmptyException;
import info.mintymods.mss.webapp.repository.AccessHistoryRepository;
import info.mintymods.mss.webapp.repository.AccountRepository;
import info.mintymods.mss.webapp.repository.AccountRoleRepository;
import info.mintymods.mss.webapp.service.AccountService;
import info.mintymods.mss.webapp.service.MessageSourceService;

@Service
@Qualifier("userDetailsService")
public class AccountServiceImpl implements UserDetailsService, AccountService {

	private static final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private AccountRoleRepository accountRoleRepository;

	@Autowired
	private AccessHistoryRepository accessHistoryRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private MessageSourceService messageSourceService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.debug("loadUserByUsername username : {}", username);
		Optional<Account> optionalAccount = Optional.ofNullable(accountRepository.findAccountByUserId(username));
		if (optionalAccount.isPresent()) {
			return new SecureAccount(optionalAccount.get());
		} else {
			throw new UsernameNotFoundException("username = " + username);
		}
	}

	@Override
	public Account getAccount(String userId) {
		return accountRepository.findAccountByUserId(userId);
	}

	@Override
	public Account insertAdmin(Account account) {
		if (StringUtils.isEmpty(account.getPassword())) {
			throw new PasswordEmptyException(messageSourceService.getMessage(MessageKey.PASSWORD_EMPTY));
		}
		addAdminRole(account);
		String encryptedPassword = passwordEncoder.encode(account.getPassword());
		account.setPassword(encryptedPassword);
		account.setPasswordUpdatedDate(LocalDateTime.now());
		account.setActivated(true);
		account.setActivatedDate(LocalDateTime.now());
		return accountRepository.save(account);
	}

	@Override
	public Account update(Account account) {
		return accountRepository.save(account);
	}

	private void addAdminRole(Account account) {
		List<Role> roles = new ArrayList<>();
		Role adminRole = accountRoleRepository
				.findByRoleName(info.mintymods.mss.webapp.enums.Role.ROLE_ADMIN.getName());
		log.warn("Admin role : {}", adminRole);
		if (adminRole == null)
			throw new AdminRoleNotFoundException(messageSourceService.getMessage(MessageKey.ADMIN_ROLE_NOT_FOUND));
		roles.add(adminRole);
		account.setRoles(roles);
	}

	@Override
	public long getCount() {
		return accountRepository.count();
	}

	@Override
	@Transactional
	public void processLoginSuccess(Account account) {
		AccessHistory accessHistory = new AccessHistory();
		accessHistory.setAccount(account);
		accessHistory.setLoggedIn(true);
		accessHistory.setLoginDate(LocalDateTime.now());
		accessHistoryRepository.save(accessHistory);
		account.setPasswordFailureCount(0);
		account.setLastLogin(accessHistory.getLoginDate());
		accountRepository.save(account);
	}

}
