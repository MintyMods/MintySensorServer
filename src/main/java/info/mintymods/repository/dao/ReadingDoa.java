package info.mintymods.repository.dao;

import java.util.Collection;

import info.mintymods.repository.entities.Reading;

public interface ReadingDoa {

	Collection<Reading> getAllReadings();

	Reading getReadingById(int id);

	void removeReadingById(int id);

	void updateReading(Reading newReading);

	void addReading(Reading reading);

}