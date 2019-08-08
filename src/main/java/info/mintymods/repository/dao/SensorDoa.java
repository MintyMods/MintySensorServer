package info.mintymods.repository.dao;

import org.springframework.data.repository.CrudRepository;

import info.mintymods.repository.entities.Sensor;

public interface SensorDoa extends CrudRepository<Sensor, Long> {
}