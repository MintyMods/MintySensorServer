package info.mintymods.mss.webapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.mintymods.repository.dao.ProviderDao;
import info.mintymods.repository.entities.Provider;

@Service
public class ProviderService {

	@Autowired
	private ProviderDao providerDao;

	public List<Provider> getAllProviders() {
		final List<Provider> providers = new ArrayList<>();
		providerDao.findAll().forEach(providers::add);
		return providers;
	}

	public Optional<Provider> getProvider(Long id) {
		return providerDao.findById(id);
	}

	public void addProvider(Provider provider) {
		providerDao.save(provider);
	}

	public void deleteProvider(Long id) {
		providerDao.deleteById(id);
	}

	public void updateProvider(Provider provider) {
		providerDao.save(provider);
	}
}
