package info.mintymods.mss.webapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.mintymods.repository.dao.DeviceDao;
import info.mintymods.repository.entities.Device;

@Service
public class DeviceService {

	@Autowired
	private DeviceDao deviceDao;

	public List<Device> getAllDevices() {
		final List<Device> devices = new ArrayList<>();
		deviceDao.findAll().forEach(devices::add);
		return devices;
	}

	public Optional<Device> getDevice(Long id) {
		return deviceDao.findById(id);
	}

	public void addDevice(Device device) {
		deviceDao.save(device);
	}

	public void deleteDevice(Long id) {
		deviceDao.deleteById(id);
	}

	public void updateDevice(Device device) {
		deviceDao.save(device);
	}
}
