package info.mintymods.mss.webapp.services;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.mintymods.MintySensorServer;
import info.mintymods.msm.MsmMonitorResponse;
import info.mintymods.msm.MsmSensor;
import info.mintymods.msm.MsmSensorReading;
import info.mintymods.repository.entities.Reading;
import info.mintymods.repository.entities.Sensor;

@Service
public class MsmResponseService {

	private static final Logger log = LoggerFactory.getLogger(MsmResponseService.class);
	@Autowired
	private SensorService sensorService;
	@Autowired
	private ReadingService readingService;

	public void processResponse(final MsmMonitorResponse response) {
		storeSensors(response);
		storeReadings(response);
		getGarbageCollectionStats();
		if (MintySensorServer.config.isDebug()) {
			log.info(String.format("@Polled# %d Sensors, %d Readings - %s", response.getSensors().size(), response.getReadings().size(), getGarbageCollectionStats()));
		}
	}

	private String getGarbageCollectionStats() {
		long totalGarbageCollections = 0;
		long garbageCollectionTime = 0;
		for (final GarbageCollectorMXBean gc : ManagementFactory.getGarbageCollectorMXBeans()) {
			final long count = gc.getCollectionCount();
			if (count >= 0) {
				totalGarbageCollections += count;
			}
			final long time = gc.getCollectionTime();
			if (time >= 0) {
				garbageCollectionTime += time;
			}
		}
		return "Garbage Collections: " + totalGarbageCollections + " : " + garbageCollectionTime + " (ms)";
	}

	private void storeReadings(final MsmMonitorResponse response) {
		final List<MsmSensor> sensors = response.getSensors();
		for (int i = 0; i < sensors.size(); i++) {
			final MsmSensor sensor = sensors.get(i);
			final List<MsmSensorReading> readings = getReadingsbyIndex(response, i);
			readings.forEach((reading) -> {
				final Reading entity = new Reading();
				entity.setId(getReadingId(sensor, reading));
				entity.setName(reading.getLabel().getName());
				entity.setDesc(reading.getLabel().getDescription());
				entity.setSensorIndex(reading.getIndex());
				entity.setType(reading.getType());
				entity.setUnit(reading.getUnit());
				entity.setValue(reading.getValue());
				entity.setMin(reading.getMin());
				entity.setMax(reading.getMax());
				entity.setAvg(reading.getAvg());
				entity.setParentId(sensor.getId() + sensor.getInstance());
				entity.setParentName(sensor.getLabel().getName());
				entity.setInstance(sensor.getInstance());
				readingService.updateReading(entity);
			});
		}
	}

	private Long getReadingId(final MsmSensor sensor, final MsmSensorReading reading) {
		return Long.valueOf(sensor.getId() + sensor.getInstance() + reading.getId() + reading.getIndex());
	}

	private void storeSensors(final MsmMonitorResponse response) {
		final List<MsmSensor> sensors = response.getSensors();
		sensors.forEach((sensor) -> {
			final Sensor entity = new Sensor();
			entity.setName(sensor.getLabel().getName());
			entity.setDesc(sensor.getLabel().getDescription());
			entity.setId(sensor.getId() + sensor.getInstance());
			entity.setInstance(sensor.getInstance());
			sensorService.updateSensor(entity);
		});
	}

	private List<MsmSensorReading> getReadingsbyIndex(final MsmMonitorResponse response, final int index) {
		final List<MsmSensorReading> readings = response.getReadings();
		final List<MsmSensorReading> result = new ArrayList<>();
		readings.forEach((reading) -> {
			if (Long.valueOf(reading.getIndex()) == index) {
				result.add(reading);
			}
		});
		return result;
	}
}
