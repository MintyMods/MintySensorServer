package info.mintymods.repository.dao;

import org.springframework.data.repository.CrudRepository;

import info.mintymods.repository.entities.Reading;

public interface ReadingDoa extends CrudRepository<Reading, Long> {
}