package info.mintymods.mss.webapp.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import info.mintymods.repository.entities.Host;

@RestController
@RequestMapping("devices")
public class DeviceController {

	@Autowired
	private DeviceService deviceService;

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteDeviceById(@PathVariable String id) {
		deviceService.removeDeviceById(Long.valueOf(id));
	}

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Device> getAllDevices() {
		return deviceService.getAllDevices();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Host getDeviceById(@PathVariable String id) {
		return deviceService.getDeviceById(Long.valueOf(id));
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertHost(@RequestBody Host device) {
		deviceService.insertDevice(device);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateDevice(@RequestBody Host device) {
		deviceService.updateDevice(device);
	}
}
