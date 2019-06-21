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

	@Override
	public boolean equals(Object obj) {
		if (this == obj) { return true; }
		if (obj == null) { return false; }
		if (getClass() != obj.getClass()) { return false; }
		final Reading other = (Reading) obj;
		if (active != other.active) { return false; }
		if (id == null) {
			if (other.id != null) { return false; }
		} else
			if (!id.equals(other.id)) { return false; }
		if (label == null) {
			if (other.label != null) { return false; }
		} else
			if (!label.equals(other.label)) { return false; }
		if (sensor_index != other.sensor_index) { return false; }
		if (type != other.type) { return false; }
		if (unit == null) {
			if (other.unit != null) { return false; }
		} else
			if (!unit.equals(other.unit)) { return false; }
		if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value)) { return false; }
		return true;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + (active ? 1231 : 1237);
		result = (prime * result) + ((id == null) ? 0 : id.hashCode());
		result = (prime * result) + ((label == null) ? 0 : label.hashCode());
		result = (prime * result) + sensor_index;
		result = (prime * result) + ((type == null) ? 0 : type.hashCode());
		result = (prime * result) + ((unit == null) ? 0 : unit.hashCode());
		long temp;
		temp = Double.doubleToLongBits(value);
		result = (prime * result) + (int) (temp ^ (temp >>> 32));
		return result;
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
