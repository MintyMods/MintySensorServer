package info.mintymods.mss.webapp.service;

import info.mintymods.mss.webapp.domain.Account;

public interface AccountService {

	Account getAccount(String userId);

	Account insertAdmin(Account account);

	Account update(Account account);

	long getCount();

	void processLoginSuccess(Account account);
}
