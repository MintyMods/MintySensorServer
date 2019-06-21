package info.mintymods.mss.webapp.controller;

import java.util.Collection;

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

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Sensor> getAllSensors() {
		return sensorService.getAllSensors();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Sensor getSensorById(@PathVariable int id) {
		return sensorService.getSensorById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteSensorById(@PathVariable int id) {
		sensorService.removeSensorById(id);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateSensor(@RequestBody Sensor sensor) {
		// checkSensorExists(sensor.getId());
		sensorService.updateSensor(sensor);
		return new ResponseEntity<>("Sensor " + sensor.getId() + " updated", HttpStatus.OK);
	}

	// private ResponseEntity<String> checkSensorExists(int id) {
	// if (sensorService.getSensorById(id) == null) {
	// return new ResponseEntity<>("Sensor " + id + " was not found", HttpStatus.NOT_FOUND);
	// } else return
	// }

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> insertSensor(@RequestBody Sensor sensor) {
		sensorService.insertSensor(sensor);
		return new ResponseEntity<>("result successful result", HttpStatus.OK);
	}
}
