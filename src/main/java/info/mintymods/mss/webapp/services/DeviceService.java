package info.mintymods.mss.webapp.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import info.mintymods.repository.dao.HostDao;

@Service
public class DeviceService {

	@Autowired
	@Qualifier("fakeData")
	private HostDao sensorsDao;
	@Autowired
	@Qualifier("fakeData")
	private HostDao readingsDao;

	public Collection<Device> getAllDevice() {
		// @todo implement
		return null;
	}

	public DevicegetDeviceById(Long id) {
		//@todo implement
		return null;
	}

	public void insertDevice(Device device) {
		// @todo implement
		return null;
	}

	public void removeDeviceById(Long id) {
		// @todo implement
		return null;
	}

	public void updateDevice(Device device) {
		// @todo implement
		return null;
	}
}
