package info.mintymods.repository.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import info.mintymods.repository.entities.Sensor;

public interface SensorDoa extends PagingAndSortingRepository<Sensor, Long> {
}