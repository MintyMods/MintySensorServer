package info.mintymods.mss.webapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.mintymods.repository.dao.ReadingDoa;
import info.mintymods.repository.entities.Reading;

@Service
public class ReadingService {

	@Autowired
	private ReadingDoa readingDoa;

	public List<Reading> getAllReadings() {
		final List<Reading> readings = new ArrayList<>();
		readingDoa.findAll().forEach(readings::add);
		return readings;
	}

	public Optional<Reading> getReading(Long id) {
		return readingDoa.findById(id);
	}

	public void addReading(Reading reading) {
		readingDoa.save(reading);
	}

	public void deleteReading(Long id) {
		readingDoa.deleteById(id);
	}

	public void updateReading(Reading reading) {
		readingDoa.save(reading);
	}
}
