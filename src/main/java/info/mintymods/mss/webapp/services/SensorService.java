package info.mintymods.mss.webapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.mintymods.repository.dao.SensorDoa;
import info.mintymods.repository.entities.Sensor;

@Service
public class SensorService {

	@Autowired
	private SensorDoa sensorDoa;

	public List<Sensor> getAllSensors() {
		final List<Sensor> sensors = new ArrayList<>();
		sensorDoa.findAll().forEach(sensors::add);
		return sensors;
	}

	public Optional<Sensor> getSensor(Long id) {
		return sensorDoa.findById(id);
	}

	public void addSensor(Sensor sensor) {
		sensorDoa.save(sensor);
	}

	public void deleteSensor(Long id) {
		sensorDoa.deleteById(id);
	}

	public void updateSensor(Sensor sensor) {
		sensorDoa.save(sensor);
	}
}
