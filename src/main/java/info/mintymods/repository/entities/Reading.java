package info.mintymods.repository.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import info.mintymods.msm.MsmSensorType;

public class Reading extends Audit {

	private final static String ICON = "fab fa-cloudscale";

	public static String getIcon() {
		return ICON;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private boolean active = true;
	private MsmSensorType type;
	private int sensor_index;
	private Label label;
	private String unit;
	private double value;

	public Reading() {
	}

	public Reading(Long id, MsmSensorType type, Label label, int sensor_index, String unit, double value) {
		this.type = type;
		this.label = label;
		this.sensor_index = sensor_index;
		this.unit = unit;
		this.value = value;
	}

	public Long getId() {
		return id;
	}

	public Label getLabel() {
		return label;
	}

	public int getSensor_index() {
		return sensor_index;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	public void setSensor_index(int sensor_index) {
		this.sensor_index = sensor_index;
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
