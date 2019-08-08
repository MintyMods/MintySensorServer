package info.mintymods.mss.webapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.mintymods.repository.dao.HostDao;
import info.mintymods.repository.entities.Host;

@Service
public class HostService {

	@Autowired
	private HostDao hostDao;

	public List<Host> getAllHosts() {
		final List<Host> hosts = new ArrayList<>();
		hostDao.findAll().forEach(hosts::add);
		return hosts;
	}

	public Optional<Host> getHost(Long id) {
		return hostDao.findById(id);
	}

	public void addHost(Host host) {
		hostDao.save(host);
	}

	public void deleteHost(Long id) {
		hostDao.deleteById(id);
	}

	public void updateHost(Host host) {
		hostDao.save(host);
	}
}
