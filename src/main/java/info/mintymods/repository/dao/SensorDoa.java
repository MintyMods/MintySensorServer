package info.mintymods.repository.dao;

import java.util.Collection;

import info.mintymods.repository.entities.Sensor;

public interface SensorDoa {

	void addSensor(Sensor sensor);

	Collection<Sensor> getAllSensors();

	Sensor getSensorById(Long id);

	void removeSensorById(Long id);

	void updateSensor(Sensor newSensor);
}