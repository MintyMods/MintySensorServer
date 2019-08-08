package info.mintymods.repository.dao.h2;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import info.mintymods.repository.dao.ViewDao;
import info.mintymods.repository.entities.View;

@Repository
@Qualifier("h2Data")
public class H2ViewDaoImpl implements ViewDao {

	@Override
	public <S extends View> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends View> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<View> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<View> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<View> findAllById(Iterable<Long> ids) {
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
	public void delete(View entity) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteAll(Iterable<? extends View> entities) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
	}
}
