package info.mintymods.repository.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import info.mintymods.repository.entities.Sensor;

@Repository
public interface SensorDoa extends PagingAndSortingRepository<Sensor, Long> {
}