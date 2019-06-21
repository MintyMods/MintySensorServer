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

	public Host getHostById(int id) {
		return hostDao.getHostById(id);
	}
	
	public void removeHostById(int id) {
		this.hostDao.removeHostById(id);
	}

	public void updateHost(Host host) {
		hostDao.updateHost(host);
	}

	public void insertHost(Host host) {
		hostDao.addHost(host);
	}
}
