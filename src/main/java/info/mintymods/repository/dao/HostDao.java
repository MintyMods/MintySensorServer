package info.mintymods.repository.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import info.mintymods.repository.entities.Host;

@Repository
public interface HostDao extends PagingAndSortingRepository<Host, Long> {
}