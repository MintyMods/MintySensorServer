package info.mintymods.repository.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import info.mintymods.repository.entities.Provider;

@Repository
public interface ProviderDao extends PagingAndSortingRepository<Provider, Long> {
}