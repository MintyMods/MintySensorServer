package info.mintymods.repository.dao.h2;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import info.mintymods.repository.dao.SensorDoa;
import info.mintymods.repository.entities.Sensor;

@Repository
@Qualifier("h2Data")
public class SensorDaoImpl implements SensorDoa {

	@Override
	public Collection<Sensor> getAllSensors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sensor getSensorById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeSensorById(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateSensor(Sensor newSensor) {
		// TODO Auto-generated method stub
	}

	@Override
	public void addSensor(Sensor sensor) {
		// TODO Auto-generated method stub
	}

}
