package info.mintymods.repository.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

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
	@NotAudited
	private MsmSensorType type;
	@NotAudited
	private String name;
	@Audited
	private String desc;
	@Audited
	private int sensorIndex;
	@Audited
	private String unit;
	@Audited
	private double value;
	@NotAudited
	private Long parentId;
	@Audited
	private double min;
	@Audited
	private double max;
	@Audited
	private double avg;
	@NotAudited
	private String parentName;
	@Audited
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

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Long getParentId() {
		return parentId;
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String name) {
		parentName = name;
	}

	public void setInstance(int instance) {
		this.instance = instance;
	}

	public int getInstance() {
		return instance;
	}
}
