package info.mintymods.mss.webapp.service;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

import info.mintymods.msm.MsmMonitorResponse;
import info.mintymods.msm.MsmSensor;
import info.mintymods.msm.MsmSensorReading;
import info.mintymods.msm.MsmSensorType;
import info.mintymods.mss.webapp.websocket.WebSocketConfiguration;
import info.mintymods.mss.webapp.websocket.WebSocketInstruction;
import info.mintymods.mss.webapp.websocket.WebSocketResponse;
import info.mintymods.utils.MintyJsonUtils;

@Service
public class MsmEventEmittingService {

	@Autowired
	private SimpMessageSendingOperations messagingTemplate;
	private boolean debug = false;

	public void processResponse(final MsmMonitorResponse response) {
		emitReadings(response);
		if (debug) {
			getGarbageCollectionStats();
			// sendMessage(WebSocketConfiguration.API_CHANNEL, "DEBUG",
			// String.format("@EventEmitterPolled# %d Sensors, %d Readings - %s", response.getSensors().size(), response.getReadings().size(), getGarbageCollectionStats()));
		}
	}

	public void sendMessage(final String channel, final String sender, final WebSocketResponse result) {
		final WebSocketInstruction message = new WebSocketInstruction();
		message.setType(result.getType());
		message.setSender(sender);
		message.setContent(MintyJsonUtils.getJsonString(result));
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
		// sensors.forEach((sensor) -> {
		// sendMessage(WebSocketConfiguration.API_CHANNEL, "Sensor:" + sensor.getLabel().getName());
		// });
	}

	private void emitReadings(final MsmMonitorResponse response) {
		final List<MsmSensor> sensors = response.getSensors();
		final List<MsmSensorReading> readings = response.getReadings();
		readings.forEach((reading) -> {
			final WebSocketResponse result = new WebSocketResponse();
			final MsmSensor sensor = sensors.get(reading.getIndex());
			result.setName(reading.getLabel().getName());
			result.setUnit(reading.getUnit());
			result.setValue(reading.getValue());
			result.setType(reading.getType());
			result.setParentName(sensor.getLabel().getName());
			if ((result.getType() == MsmSensorType.FAN) || (result.getType() == MsmSensorType.TEMP)) {
				final String channel = WebSocketConfiguration.API_CHANNEL;
				sendMessage(channel, result.getParentName(), result);
			}
		});
	}

	public boolean isDebug() {
		return debug;
	}

	public void setDebug(final boolean debug) {
		this.debug = debug;
	}
}
