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

import info.mintymods.mss.webapp.services.ReadingService;
import info.mintymods.repository.entities.Reading;

@RestController
@RequestMapping("readings")
public class ReadingController {

	@Autowired
	private ReadingService readingService;

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteReadingById(@PathVariable final Long id) {
		readingService.deleteReading(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Reading> getAllReadings() {
		return readingService.getAllReadings();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Reading> getReadingById(@PathVariable final Long id) {
		return readingService.getReading(id);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> insertReading(@RequestBody final Reading reading) {
		readingService.addReading(reading);
		return new ResponseEntity<>("Reading " + reading.getId() + " added", HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateReading(@RequestBody final Reading reading) {
		readingService.updateReading(reading);
		return new ResponseEntity<>("Reading " + reading.getId() + " updated", HttpStatus.OK);
	}
}
