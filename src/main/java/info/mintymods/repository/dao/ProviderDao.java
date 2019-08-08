package info.mintymods.repository.dao;

import org.springframework.data.repository.CrudRepository;

import info.mintymods.repository.entities.Provider;

public interface ProviderDao extends CrudRepository<Provider, Long> {
}