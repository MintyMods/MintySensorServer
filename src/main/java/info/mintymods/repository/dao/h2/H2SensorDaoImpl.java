package info.mintymods.repository.dao.h2;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import info.mintymods.repository.dao.SensorDoa;
import info.mintymods.repository.entities.Sensor;

@Repository
@Qualifier("h2Data")
public class H2SensorDaoImpl implements SensorDoa {

	@Override
	public <S extends Sensor> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Sensor> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Sensor> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Sensor> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Sensor> findAllById(Iterable<Long> ids) {
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
	public void delete(Sensor entity) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteAll(Iterable<? extends Sensor> entities) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
	}
}
