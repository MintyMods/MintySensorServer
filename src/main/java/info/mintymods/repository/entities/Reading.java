package info.mintymods.repository.entities;

import info.mintymods.msm.MsmSensorType;

public class Reading {

	private MsmSensorType type;
	private int id;
	private int sensor_index;
	private Label label;
	private String unit;
	private double value;

	public Reading() { }

	public Reading(int id, MsmSensorType type, Label label, int sensor_index, String unit, double value) {
		this.type = type;
		this.sensor_index = sensor_index;
		this.label = label;
		this.unit = unit;
		this.value = value;
	}

	public MsmSensorType getType() {
		return type;
	}

	public void setType(MsmSensorType type) {
		this.type = type;
	}

	public int getSensor_index() {
		return sensor_index;
	}

	public void setSensor_index(int sensor_index) {
		this.sensor_index = sensor_index;
	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
