package info.mintymods.mss.webapp.websocket;

import info.mintymods.msm.MsmSensorType;

public class WebSocketResponse {

	private String unit;
	private double value;
	// private double min;
	// private double max;
	// private double avg;
	private String name;
	// private int instance;
	// private int sensorIndex;
	private String parentName;
	private MsmSensorType type;

	public String getUnit() {
		return unit;
	}

	public void setUnit(final String unit) {
		this.unit = unit;
	}

	public double getValue() {
		return value;
	}

	public void setValue(final double value) {
		this.value = value;
	}

	// public double getMin() {
	// return min;
	// }
	//
	// public void setMin(final double min) {
	// this.min = min;
	// }
	//
	// public double getMax() {
	// return max;
	// }
	//
	// public void setMax(final double max) {
	// this.max = max;
	// }
	//
	// public double getAvg() {
	// return avg;
	// }
	//
	// public void setAvg(final double avg) {
	// this.avg = avg;
	// }
	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	// public int getInstance() {
	// return instance;
	// }
	//
	// public void setInstance(final int instance) {
	// this.instance = instance;
	// }
	//
	// public int getSensorIndex() {
	// return sensorIndex;
	// }
	//
	// public void setSensorIndex(final int sensorIndex) {
	// this.sensorIndex = sensorIndex;
	// }
	public String getParentName() {
		return parentName;
	}

	public void setParentName(final String parentName) {
		this.parentName = parentName;
	}

	public void setType(final MsmSensorType type) {
		this.type = type;
	}

	public MsmSensorType getType() {
		return type;
	}
}
