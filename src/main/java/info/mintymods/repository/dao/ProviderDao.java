package info.mintymods.repository.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import info.mintymods.repository.entities.Provider;

public interface ProviderDao extends PagingAndSortingRepository<Provider, Long> {
}