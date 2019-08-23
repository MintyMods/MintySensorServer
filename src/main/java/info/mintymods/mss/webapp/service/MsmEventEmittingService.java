package info.mintymods.mss.webapp.service;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

import info.mintymods.msm.MsmMonitorResponse;
import info.mintymods.msm.MsmSensor;
import info.mintymods.msm.MsmSensorReading;
import info.mintymods.mss.webapp.websocket.WebSocketConfiguration;
import info.mintymods.mss.webapp.websocket.WebSocketInstruction;
import info.mintymods.repository.entities.Reading;
import info.mintymods.utils.MintyJsonUtils;

@Service
public class MsmEventEmittingService {

	@Autowired
	private SimpMessageSendingOperations messagingTemplate;
	List<MsmSensor> sensors;
	private boolean debug = false;

	public void processResponse(final MsmMonitorResponse response) {
		emitReadings(response);
		sensors = response.getSensors();
		getGarbageCollectionStats();
		if (debug) {
			sendMessage(WebSocketConfiguration.API_CHANNEL,
					String.format("@EventEmitterPolled# %d Sensors, %d Readings - %s", response.getSensors().size(), response.getReadings().size(), getGarbageCollectionStats()));
		}
	}

	public void sendMessage(final String channel, final String content) {
		final WebSocketInstruction message = new WebSocketInstruction();
		message.setType(WebSocketInstruction.MessageType.CHAT);
		message.setSender("SERVER");
		message.setContent(content);
		messagingTemplate.convertAndSend(channel, message);
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

	public void sendSensors() {
		sensors.forEach((sensor) -> {
			sendMessage(WebSocketConfiguration.API_CHANNEL, "Sensor:" + sensor.getLabel().getName());
		});
	}

	private void emitReadings(final MsmMonitorResponse response) {
		final List<MsmSensor> sensors = response.getSensors();
		for (int i = 0; i < sensors.size(); i++) {
			final MsmSensor sensor = sensors.get(i);
			// sendMessage("", "Sensor:" + sensor.getLabel().getName());
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
				final String channel = WebSocketConfiguration.API_CHANNEL + "/" + entity.getParentName() + "/" + entity.getInstance();
				sendMessage(channel, MintyJsonUtils.getJsonString(entity));
			});
		}
	}

	private Long getReadingId(final MsmSensor sensor, final MsmSensorReading reading) {
		return Long.valueOf(sensor.getId() + sensor.getInstance() + reading.getId() + reading.getIndex());
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

	public boolean isDebug() {
		return debug;
	}

	public void setDebug(final boolean debug) {
		this.debug = debug;
	}
}
