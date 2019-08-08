package info.mintymods.repository.dao.h2;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import info.mintymods.repository.dao.ProviderDao;
import info.mintymods.repository.entities.Provider;

@Repository
@Qualifier("h2Data")
public class H2ProviderDaoImpl implements ProviderDao {

	
	@Override
	public <S extends Provider> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Provider> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Provider> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Provider> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Provider> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(Provider entity) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteAll(Iterable<? extends Provider> entities) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
	}
}
