package info.mintymods.mss.webapp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import info.mintymods.mss.webapp.domain.Role;

@Repository
public interface AccountRoleRepository extends PagingAndSortingRepository<Role, Long> {
    Role findByRoleName(String roleName);
}