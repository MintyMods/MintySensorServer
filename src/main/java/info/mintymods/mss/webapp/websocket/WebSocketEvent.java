package info.mintymods.mss.webapp.websocket;

import java.util.List;

import info.mintymods.msm.MsmMonitorResponse;
import info.mintymods.msm.MsmSensor;
import info.mintymods.msm.MsmSensorReading;

public class WebSocketEvent {

	List<MsmSensorReading> readings;
	List<MsmSensor> sensors;

	public WebSocketEvent(final MsmMonitorResponse response) {
		readings = response.getReadings();
		sensors = response.getSensors();
	}

	public List<MsmSensorReading> getReadings() {
		return readings;
	}

	public void setReadings(final List<MsmSensorReading> readings) {
		this.readings = readings;
	}

	public List<MsmSensor> getSensors() {
		return sensors;
	}

	public void setSensors(final List<MsmSensor> sensors) {
		this.sensors = sensors;
	}
}
