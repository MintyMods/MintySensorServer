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

import info.mintymods.mss.webapp.services.SensorService;
import info.mintymods.repository.entities.Sensor;

@RestController
@RequestMapping("sensors")
public class SensorController {

	@Autowired
	private SensorService sensorService;

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteSensorById(@PathVariable Long id) {
		sensorService.deleteSensor(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Sensor> getAllSensors() {
		return sensorService.getAllSensors();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Sensor> getSensorById(@PathVariable Long id) {
		return sensorService.getSensor(id);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> insertSensor(@RequestBody Sensor sensor) {
		sensorService.addSensor(sensor);
		return new ResponseEntity<String>("Sensor " + sensor.getRecordId() + " added", HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateSensor(@RequestBody Sensor sensor) {
		sensorService.updateSensor(sensor);
		return new ResponseEntity<String>("Sensor " + sensor.getRecordId() + " updated", HttpStatus.OK);
	}
}
