package info.mintymods.repository.dao;

import org.springframework.data.repository.CrudRepository;

import info.mintymods.repository.entities.Host;

public interface HostDao extends CrudRepository<Host, Long> {
}