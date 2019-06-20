package info.mintymods.mss.webapp.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.mintymods.mss.repository.dao.ReadingDao;
import info.mintymods.mss.repository.entities.Reading;

@Service
public class ReadingService {

	@Autowired
	private ReadingDao readingDoa;

	public Collection<Reading> getAllSensors() {
		return readingDoa.getAllReadings();
	}

}
