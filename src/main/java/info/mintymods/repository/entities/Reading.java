package info.mintymods.repository.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import info.mintymods.msm.MsmSensorType;

@Audited
@Entity
@Table(name = "minty_reading")
public class Reading extends BaseEntity {

	private MsmSensorType type;
	private int sensorIndex;
	private String unit;
	private double value;

	public Reading() {
	}

	public Reading(Long recordId, MsmSensorType type, Label label, int sensorIndex, String unit, double value) {
		this.type = type;
		this.label = label;
		this.unit = unit;
		this.value = value;
		this.sensorIndex = sensorIndex;
		icon = "fab fa-cloudscale";
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
