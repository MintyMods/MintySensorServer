package info.mintymods.repository.dao;

import java.util.Collection;

import info.mintymods.repository.entities.Provider;

public interface ProviderDao {

	Collection<Provider> getAllProviders();

	Provider getProviderById(int id);

	void removeProviderById(int id);

	void updateProvider(Provider provider);

	void addProvider(Provider provider);
}