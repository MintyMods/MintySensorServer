package info.mintymods.repository.dao;

import java.util.Collection;

import info.mintymods.repository.entities.Host;

public interface HostDao {

	void addHost(Host host);

	Collection<Host> getAllHosts();

	Host getHostById(Long id);

	void removeHostById(Long id);

	void updateHost(Host host);
}