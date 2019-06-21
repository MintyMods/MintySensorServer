package info.mintymods.repository.dao.fake;

import static info.mintymods.msm.MsmSensorType.CLOCK;
import static info.mintymods.msm.MsmSensorType.POWER;
import static info.mintymods.msm.MsmSensorType.TEMP;
import static info.mintymods.msm.MsmSensorType.USAGE;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import info.mintymods.repository.dao.ReadingDoa;
import info.mintymods.repository.entities.Label;
import info.mintymods.repository.entities.Reading;

@Repository
@Qualifier("fakeData")
public class ReadingDaoImpl implements ReadingDoa {

	private static Map<Integer, Reading> readings;

	static {
		readings = new HashMap<Integer, Reading>() {

			private static final long serialVersionUID = -1494841068458602731L;

			{
				put(100663296, new Reading(100663296, CLOCK, new Label("Core #0 Clock", CLOCK), 0, "MHz", 1300));
				put(100663297, new Reading(100663297, CLOCK, new Label("Core #1 Clock", CLOCK), 0, "MHz", 1300));
				put(100663298, new Reading(100663298, CLOCK, new Label("Core #2 Clock", CLOCK), 0, "MHz", 1300));
				put(100663299, new Reading(100663299, CLOCK, new Label("Core #3 Clock", CLOCK), 0, "MHz", 1300));
				put(100663300, new Reading(100663300, CLOCK, new Label("Core #3 Clock", CLOCK), 0, "MHz", 1300));
				put(16777216, new Reading(16777216, TEMP, new Label("GPU Temperature", TEMP), 0, "\\ufffdC", 42));
				put(117440512, new Reading(117440512, USAGE, new Label("GPU Core Load", USAGE), 0, "%", 3));
				put(83886080, new Reading(83886080, POWER, new Label("CPU Package Power", POWER), 0, "W", 78.485));

			}
		};

	}

	@Override
	public Collection<Reading> getAllReadings() {
		return readings.values();
	}

	@Override
	public Reading getReadingById(int id) {
		return readings.get(id);
	}

	@Override
	public void removeReadingById(int id) {
		readings.remove(id);
	}

	@Override
	public void updateReading(Reading reading) {
		Reading original = readings.get(reading.getId());
		original.setLabel(reading.getLabel());
		readings.put(reading.getId(), original);
	}

	@Override
	public void addReading(Reading reading) {
		readings.put(reading.getId(), reading);
	}
}
