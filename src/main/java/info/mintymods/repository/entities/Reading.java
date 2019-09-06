package info.mintymods.repository.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import info.mintymods.msm.MsmSensorType;

@Entity
@Table(name = "minty_reading")
public class Reading {

	// @GeneratedName(strategy = GenerationType.AUTO, generator = "minty_sensor_gen")
	// @SequenceGenerator(name = "minty_sensor_gen", sequenceName = "MINTY_SENSOR_SEQ")
	@Id
	@Column(name = "id", updatable = true, nullable = false)
	protected Long id;
	public static final String ICON = "fab fa-cloudscale";
	private MsmSensorType type;
	private String name;
	private String desc;
	private int sensorIndex;
	private String sensorIndexName;
	private String unit;
	private double value;
	private Long parentId;
	private double min;
	private double max;
	private double avg;
	private String parentName;
	private int instance;

	public Reading() {
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

	public void setSensorIndex(final int sensor_index) {
		sensorIndex = sensor_index;
	}

	public void setType(final MsmSensorType type) {
		this.type = type;
	}

	public void setUnit(final String unit) {
		this.unit = unit;
	}

	public void setValue(final double value) {
		this.value = value;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(final String desc) {
		this.desc = desc;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public void setParentId(final Long parentId) {
		this.parentId = parentId;
	}

	public Long getParentId() {
		return parentId;
	}

	public double getMin() {
		return min;
	}

	public void setMin(final double min) {
		this.min = min;
	}

	public double getMax() {
		return max;
	}

	public void setMax(final double max) {
		this.max = max;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(final double avg) {
		this.avg = avg;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(final String name) {
		parentName = name;
	}

	public void setInstance(final int instance) {
		this.instance = instance;
	}

	public int getInstance() {
		return instance;
	}

	public String getSensorIndexName() {
		return sensorIndexName;
	}

	public void setSensorIndexName(final String sensorIndexName) {
		this.sensorIndexName = sensorIndexName;
	}
}
