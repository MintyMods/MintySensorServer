package info.mintymods.mss.webapp.websocket;

import java.util.List;

import info.mintymods.msm.MsmMonitorResponse;
import info.mintymods.msm.MsmSensor;
import info.mintymods.msm.MsmSensorReading;
import info.mintymods.msm.MsmSensorType;

public class WebSocketEvent {

	List<MsmSensorReading> readings;
	List<MsmSensor> sensors;
	MsmSensorType[] types;

	public WebSocketEvent(final MsmMonitorResponse response) {
		readings = response.getReadings();
		sensors = response.getSensors();
		types = MsmSensorType.values();
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

	public MsmSensorType[] getTypes() {
		return types;
	}

	public void setTypes(final MsmSensorType[] types) {
		this.types = types;
	}
}
