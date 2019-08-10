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
public abstract class FakeReadingDaoImpl implements ReadingDoa {

	private static Map<Long, Reading> readings;
	static {
		readings = new HashMap<Long, Reading>() {

			private static final long serialVersionUID = -1494841068458602731L;
			{
				put(100663296l, new Reading(100663296l, CLOCK, new Label("Core #0 Clock", CLOCK), 0, "MHz", 1300));
				put(100663297l, new Reading(100663297l, CLOCK, new Label("Core #1 Clock", CLOCK), 0, "MHz", 1300));
				put(100663298l, new Reading(100663298l, CLOCK, new Label("Core #2 Clock", CLOCK), 0, "MHz", 1300));
				put(100663299l, new Reading(100663299l, CLOCK, new Label("Core #3 Clock", CLOCK), 0, "MHz", 1300));
				put(100663300l, new Reading(100663300l, CLOCK, new Label("Core #3 Clock", CLOCK), 0, "MHz", 1300));
				put(16777216l, new Reading(16777216l, TEMP, new Label("GPU Temperature", TEMP), 0, "\\ufffdC", 42));
				put(117440512l, new Reading(117440512l, USAGE, new Label("GPU Core Load", USAGE), 0, "%", 3));
				put(83886080l, new Reading(83886080l, POWER, new Label("CPU Package Power", POWER), 0, "W", 78.485));
			}
		};
	}

	public void addReading(Reading reading) {
		readings.put(reading.getId(), reading);
	}

	public Collection<Reading> getAllReadings() {
		return readings.values();
	}

	public Reading getReadingById(Long id) {
		return readings.get(id);
	}

	public void removeReadingById(Long id) {
		readings.remove(id);
	}

	public void updateReading(Reading reading) {
		final Reading original = readings.get(reading.getId());
		original.setLabel(reading.getLabel());
		readings.put(reading.getId(), original);
	}
}
