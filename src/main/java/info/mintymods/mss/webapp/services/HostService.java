package info.mintymods.mss.webapp.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import info.mintymods.repository.dao.HostDao;
import info.mintymods.repository.entities.Host;

@Service
public class HostService {

	@Autowired
	@Qualifier("fakeData")
	private HostDao hostDao;

	public Collection<Host> getAllHosts() {
		return hostDao.getAllHosts();
	}

	public Host getHostById(Long id) {
		return hostDao.getHostById(id);
	}

	public void insertHost(Host host) {
		hostDao.addHost(host);
	}

	public void removeHostById(Long id) {
		hostDao.removeHostById(id);
	}

	public void updateHost(Host host) {
		hostDao.updateHost(host);
	}
}
