package info.mintymods.repository.dao.mongodb;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import info.mintymods.repository.dao.HostDao;
import info.mintymods.repository.entities.Host;

@Repository
@Qualifier("mongodbData")
public class MongoDbHostDaoImpl implements HostDao {

	@Override
	public void addHost(Host host) {
		// TODO Auto-generated method stub
	}

	@Override
	public Collection<Host> getAllHosts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Host getHostById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeHostById(Long id) {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateHost(Host host) {
		// TODO Auto-generated method stub
	}
}
