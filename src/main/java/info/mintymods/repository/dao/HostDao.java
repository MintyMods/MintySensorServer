package info.mintymods.repository.dao;

import java.util.Collection;

import info.mintymods.repository.entities.Host;

public interface HostDao {

	Collection<Host> getAllHosts();

	Host getHostById(int id);

	void removeHostById(int id);

	void updateHost(Host host);

	void addHost(Host host);
}