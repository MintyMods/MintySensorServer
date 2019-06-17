package info.mintymods.mss.webapp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import info.mintymods.mss.webapp.domain.AccessHistory;

@Repository
public interface AccessHistoryRepository extends PagingAndSortingRepository<AccessHistory, Long> {

}