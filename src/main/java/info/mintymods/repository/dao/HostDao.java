package info.mintymods.repository.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import info.mintymods.repository.entities.Host;

public interface HostDao extends PagingAndSortingRepository<Host, Long> {
}