package info.mintymods.mss.webapp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import info.mintymods.mss.webapp.domain.Account;

@Repository
public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {
    Account findAccountByUserId(String userId);
    Account findAccountByEmail(String email);
}