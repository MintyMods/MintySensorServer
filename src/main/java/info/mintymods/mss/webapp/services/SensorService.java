package info.mintymods.mss.webapp.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import info.mintymods.repository.dao.SensorDoa;
import info.mintymods.repository.entities.Sensor;

@Service
public class SensorService {

	@Autowired
	@Qualifier("fakeData")
	private SensorDoa sensorDoa;

	public Collection<Sensor> getAllSensors() {
		return sensorDoa.getAllSensors();
	}

	public Sensor getSensorById(Long id) {
		return sensorDoa.getSensorById(id);
	}

	public void insertSensor(Sensor sensor) {
		sensorDoa.addSensor(sensor);
	}

	public void removeSensorById(Long id) {
		sensorDoa.removeSensorById(id);
	}

	public void updateSensor(Sensor sensor) {
		sensorDoa.updateSensor(sensor);
	}
}
