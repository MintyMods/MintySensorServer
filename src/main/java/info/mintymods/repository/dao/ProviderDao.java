package info.mintymods.repository.dao;

import java.util.Collection;

import info.mintymods.repository.entities.Provider;

public interface ProviderDao {

	void addProvider(Provider provider);

	Collection<Provider> getAllProviders();

	Provider getProviderById(Long id);

	void removeProviderById(Long id);

	void updateProvider(Provider provider);
}