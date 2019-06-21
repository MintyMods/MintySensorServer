package info.mintymods.repository.dao.h2;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import info.mintymods.repository.dao.ReadingDoa;
import info.mintymods.repository.entities.Reading;

@Repository
@Qualifier("h2Data")
public class ReadingDaoImpl implements ReadingDoa {

	@Override
	public Collection<Reading> getAllReadings() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reading getReadingById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeReadingById(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateReading(Reading newReading) {
		// TODO Auto-generated method stub
	}

	@Override
	public void addReading(Reading reading) {
		// TODO Auto-generated method stub
	}

}
