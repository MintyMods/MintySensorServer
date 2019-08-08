package info.mintymods.repository.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import info.mintymods.msm.MsmSensorType;

@Entity
@Table(name = "minty_provider")
public class Reading extends BaseEntity {

	private final static String ICON = "fab fa-cloudscale";
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private MsmSensorType type;
	private int sensorIndex;
	private String unit;
	private double value;

	public Reading() {
	}

	public Reading(Long id, MsmSensorType type, Label label, int sensor_index, String unit, double value) {
		this.type = type;
		this.label = label;
		sensorIndex = sensor_index;
		this.unit = unit;
		this.value = value;
	}

	public String getIcon() {
		return ICON;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public Label getLabel() {
		return label;
	}

	public int getSensor_index() {
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

	@Override
	public boolean isActive() {
		return active;
	}

	@Override
	public void setActive(boolean active) {
		this.active = active;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public void setLabel(Label label) {
		this.label = label;
	}

	public void setSensor_index(int sensor_index) {
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
