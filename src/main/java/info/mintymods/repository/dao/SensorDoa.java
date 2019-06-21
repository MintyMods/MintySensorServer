package info.mintymods.repository.dao;

import java.util.Collection;

import info.mintymods.repository.entities.Sensor;

public interface SensorDoa {

	Collection<Sensor> getAllSensors();

	Sensor getSensorById(int id);

	void removeSensorById(int id);

	void updateSensor(Sensor newSensor);

	void addSensor(Sensor sensor);

}