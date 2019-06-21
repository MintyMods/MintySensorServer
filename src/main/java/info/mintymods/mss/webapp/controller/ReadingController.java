package info.mintymods.mss.webapp.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import info.mintymods.mss.webapp.services.ReadingService;
import info.mintymods.repository.entities.Reading;

@RestController
@RequestMapping("readings")
public class ReadingController {

	@Autowired
	private ReadingService readingService;

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteReadingById(@PathVariable Long id) {
		readingService.removeReadingById(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Reading> getAllSensors() {
		return readingService.getAllReadings();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Reading getReadingById(@PathVariable Long id) {
		return readingService.getReadingById(id);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertReading(@RequestBody Reading reading) {
		readingService.insertReading(reading);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateReading(@RequestBody Reading reading) {
		readingService.updateReading(reading);
	}
}
