package info.mintymods.repository.dao;

import java.util.Collection;

import info.mintymods.repository.entities.Reading;

public interface ReadingDoa {

	void addReading(Reading reading);

	Collection<Reading> getAllReadings();

	Reading getReadingById(Long id);

	void removeReadingById(Long id);

	void updateReading(Reading newReading);
}