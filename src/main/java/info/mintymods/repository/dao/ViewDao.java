package info.mintymods.repository.dao;

import org.springframework.data.repository.CrudRepository;

import info.mintymods.repository.entities.View;

public interface ViewDao extends CrudRepository<View, Long> {
}