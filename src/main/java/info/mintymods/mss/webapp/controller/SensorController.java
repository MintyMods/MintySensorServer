package info.mintymods.mss.webapp.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import info.mintymods.mss.repository.entities.Sensor;
import info.mintymods.mss.webapp.services.SensorService;

@RestController
@RequestMapping("sensors")
public class SensorController {

	@Autowired
	private SensorService sensorService;

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Sensor> getAllSensors() {
		return sensorService.getAllSensors();
	}

}
