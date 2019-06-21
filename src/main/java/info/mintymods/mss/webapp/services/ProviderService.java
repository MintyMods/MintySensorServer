package info.mintymods.mss.webapp.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import info.mintymods.repository.dao.ProviderDao;
import info.mintymods.repository.entities.Provider;

@Service
public class ProviderService {

	@Autowired
	@Qualifier("fakeData")
	private ProviderDao providerDao;

	public Collection<Provider> getAllProviders() {
		return providerDao.getAllProviders();
	}

	public Provider getProviderById(int id) {
		return providerDao.getProviderById(id);
	}
	
	public void removeProviderById(int id) {
		this.providerDao.removeProviderById(id);
	}

	public void updateProvider(Provider provider) {
		providerDao.updateProvider(provider);
	}

	public void insertProvider(Provider provider) {
		providerDao.addProvider(provider);
	}
}
