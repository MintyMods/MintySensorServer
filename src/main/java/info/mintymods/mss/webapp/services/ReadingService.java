package info.mintymods.mss.webapp.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import info.mintymods.repository.dao.ReadingDoa;
import info.mintymods.repository.entities.Reading;

@Service
public class ReadingService {

	@Autowired
	@Qualifier("fakeData")
	private ReadingDoa readingDoa;

	public Collection<Reading> getAllReadings() {
		return readingDoa.getAllReadings();
	}

	public Reading getReadingById(int id) {
		return readingDoa.getReadingById(id);
	}

	public void removeReadingById(int id) {
		this.readingDoa.removeReadingById(id);
	}

	public void updateReading(Reading reading) {
		readingDoa.updateReading(reading);
	}

	public void insertReading(Reading reading) {
		readingDoa.addReading(reading);
	}
}
