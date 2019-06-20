package info.mintymods.mss.webapp.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import info.mintymods.mss.repository.entities.Reading;
import info.mintymods.mss.webapp.services.ReadingService;

@RestController
@RequestMapping("readings")
public class ReadingController {

	@Autowired
	private ReadingService readingService;

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Reading> getAllSensors() {
		return readingService.getAllSensors();
	}

}
