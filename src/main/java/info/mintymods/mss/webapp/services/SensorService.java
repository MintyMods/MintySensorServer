package info.mintymods.mss.webapp.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.mintymods.mss.repository.dao.SensorDoa;
import info.mintymods.mss.repository.entities.Sensor;

@Service
public class SensorService {

	@Autowired
	private SensorDoa sensorDoa;

	public Collection<Sensor> getAllSensors() {
		return sensorDoa.getAllSensors();
	}

}
