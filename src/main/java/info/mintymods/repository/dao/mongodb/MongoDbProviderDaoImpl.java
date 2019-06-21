package info.mintymods.repository.dao.mongodb;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import info.mintymods.repository.dao.ProviderDao;
import info.mintymods.repository.entities.Provider;

@Repository
@Qualifier("mongodbData")
public class MongoDbProviderDaoImpl implements ProviderDao {

	@Override
	public void addProvider(Provider provider) {
		// TODO Auto-generated method stub
	}

	@Override
	public Collection<Provider> getAllProviders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Provider getProviderById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeProviderById(Long id) {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateProvider(Provider provider) {
		// TODO Auto-generated method stub
	}
}
