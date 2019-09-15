package info.mintymods.mss.webapp.service;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

import info.mintymods.msm.MsmMonitorResponse;
import info.mintymods.msm.MsmSensor;
import info.mintymods.msm.MsmSensorReading;
import info.mintymods.msm.MsmSensorType;
import info.mintymods.mss.webapp.websocket.WebSocketChannel;
import info.mintymods.mss.webapp.websocket.WebSocketEvent;
import info.mintymods.mss.webapp.websocket.WebSocketInstruction;
import info.mintymods.utils.MintyJsonUtils;

@Service
public class MsmEventEmittingService {

	private static final Logger log = LoggerFactory.getLogger(MsmEventEmittingService.class);
	@Autowired
	private SimpMessageSendingOperations messagingTemplate;
	private final boolean debug = true;
	MsmMonitorResponse lastResponse;

	public void processResponse(final MsmMonitorResponse response) {
		lastResponse = response;
		emitReadings(response);
		if (debug) {
			log.info(String.format("@EventEmitterPolled# %d Sensors, %d Readings - %s", response.getSensors().size(), response.getReadings().size(),
					getGarbageCollectionStats()));
		}
	}

	public void sendSensors(final WebSocketInstruction message) {
		message.setJson(lastResponse.getSensors());
		sendMessage(message);
	}

	public void sendMessage(final WebSocketInstruction message) {
		messagingTemplate.convertAndSend(message.getChannel(), message);
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

	private void emitReadings(final MsmMonitorResponse response) {
		final WebSocketEvent event = new WebSocketEvent(response);
		final WebSocketInstruction message = new WebSocketInstruction(event);
		message.setChannel(WebSocketChannel.CHANNEL_EVENTS);
		sendMessage(message);
	}

	public void sendReadingsBySensor(final WebSocketInstruction message) {
		final MsmSensor sensor = MintyJsonUtils.getMsmSensor(message.getParameters());
		final int index = getIndexOfSensor(sensor);
		final List<MsmSensorReading> results = new ArrayList<>();
		if (hasResponse()) {
			final List<MsmSensorReading> readings = lastResponse.getReadings();
			for (final MsmSensorReading reading : readings) {
				if (reading.getIndex() == index) {
					results.add(reading);
				}
			}
		}
		message.setJson(results);
		sendMessage(message);
	}

	public void sendReadingsByType(final WebSocketInstruction message) {
		final MsmSensorType type = MintyJsonUtils.getMsmSensorType(message.getParameters());
		final List<MsmSensorReading> results = new ArrayList<>();
		if (hasResponse()) {
			final List<MsmSensorReading> readings = lastResponse.getReadings();
			for (final MsmSensorReading reading : readings) {
				if (reading.getType() == type) {
					results.add(reading);
				}
			}
		}
		message.setJson(results);
		sendMessage(message);
	}

	private boolean hasResponse() {
		if (lastResponse == null) {
			return false;
		}
		return true;
	}

	private int getIndexOfSensor(final MsmSensor sensor) {
		final List<MsmSensor> sensors = lastResponse.getSensors();
		for (int i = 0; i < sensors.size(); i++) {
			final MsmSensor temp = sensors.get(i);
			if ((temp == null) || (sensor == null)) {
				continue;
			}
			if (temp.getLabel().getName().equals(sensor.getLabel().getName()) &&
					(temp.getInstance() == sensor.getInstance())) {
				return i;
			}
		}
		return -1;
	}

	public void sendPong(final WebSocketInstruction message) {
		sendMessage(message);
	}

	public void sendTypes(final WebSocketInstruction message) {
		final MsmSensorType[] types = MsmSensorType.values();
		message.setJson(types);
		sendMessage(message);
	}

	public void sendReadings(final WebSocketInstruction message) {
		final List<MsmSensorReading> readings = lastResponse.getReadings();
		readings.forEach((reading) -> {
			if ((reading.getType() == MsmSensorType.FAN) || (reading.getType() == MsmSensorType.TEMP)) {
				message.setChannel(WebSocketChannel.CHANNEL_EVENTS);
				message.setJson(readings);
				sendMessage(message);
			}
		});
	}
}
