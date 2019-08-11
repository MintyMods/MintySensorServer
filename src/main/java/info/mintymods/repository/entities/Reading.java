package info.mintymods.repository.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import info.mintymods.msm.MsmSensorReading;
import info.mintymods.msm.MsmSensorType;

@Entity
@Table(name = "minty_reading")
public class Reading extends BaseEntity {

	private static final String ICON = "fab fa-cloudscale";
	private MsmSensorType type;
	private int sensorIndex;
	private String unit;
	private double value;

	public Reading() {
	}

	public Reading(Long recordId, MsmSensorType type, Label label, int sensorIndex, String unit, double value) {
		setType(type);
		setLabel(label);
		setUnit(unit);
		setValue(value);
		setSensorIndex(sensorIndex);
		setIcon(ICON);
	}

	public Reading(MsmSensorReading reading) {
		setType(reading.getType());
		setLabel(reading.getLabel());
		setUnit(reading.getUnit());
		setValue(reading.getValue());
		setSensorIndex(reading.getIndex());
		setIcon(ICON);
	}

	public int getSensorIndex() {
		return sensorIndex;
	}

	public MsmSensorType getType() {
		return type;
	}

	public String getUnit() {
		return unit;
	}

	public double getValue() {
		return value;
	}

	public void setSensorIndex(int sensor_index) {
		sensorIndex = sensor_index;
	}

	public void setType(MsmSensorType type) {
		this.type = type;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public void setValue(double value) {
		this.value = value;
	}
}
