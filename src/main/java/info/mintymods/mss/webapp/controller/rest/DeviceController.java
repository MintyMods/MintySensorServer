package info.mintymods.mss.webapp.controller.rest;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import info.mintymods.mss.webapp.services.DeviceService;
import info.mintymods.repository.entities.Device;

@RestController
@RequestMapping("devices")
public class DeviceController {

	@Autowired
	private DeviceService deviceService;

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteDeviceById(@PathVariable String id) {
		deviceService.deleteDevice(Long.valueOf(id));
	}

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Device> getAllDevices() {
		return deviceService.getAllDevices();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Device> getDeviceById(@PathVariable String id) {
		return deviceService.getDevice(Long.valueOf(id));
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> insertHost(@RequestBody Device device) {
		deviceService.addDevice(device);
		return new ResponseEntity<String>("Device " + device.getId() + " added", HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateDevice(@RequestBody Device device) {
		deviceService.updateDevice(device);
		return new ResponseEntity<String>("Device " + device.getId() + " updated", HttpStatus.OK);
	}
}
