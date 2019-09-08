package info.mintymods.msm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;

import info.mintymods.utils.MintyJsonUtils;

public class MsmSensorReading {

	private MsmSensorType type;
	private int id;
	private int sensor_index;
	private MsmSensorLabel label;
	private String unit;
	private double value;
	private double min;
	private double max;
	private double avg;
	private String name;

	@JsonProperty("avg")
	public double getAvg() {
		return avg;
	}

	public int getId() {
		return id;
	}

	public int getIndex() {
		return sensor_index;
	}

	public MsmSensorLabel getLabel() {
		return label;
	}

	public double getMax() {
		return max;
	}

	public double getMin() {
		return min;
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

	@JsonProperty("avg")
	public void setAvg(final double avg) {
		this.avg = avg;
	}

	@JsonProperty("id")
	public void setId(final int id) {
		this.id = id;
	}

	@JsonProperty("sensor_index")
	public void setIndex(final int index) {
		sensor_index = index;
	}

	@JsonProperty("label")
	public void setLabel(final MsmSensorLabel label) {
		this.label = label;
	}

	@JsonProperty("max")
	public void setMax(final double max) {
		this.max = max;
	}

	@JsonProperty("min")
	public void setMin(final double min) {
		this.min = min;
	}

	@JsonProperty("type")
	public void setType(final MsmSensorType type) {
		this.type = type;
	}

	@JsonProperty("unit")
	public void setUnit(final String unit) {
		this.unit = unit;
	}

	@JsonProperty("value")
	public void setValue(final double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		try {
			return MintyJsonUtils.getMapper().writeValueAsString(this);
		} catch (final JsonProcessingException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public String getIcon() {
		return type.getIcon();
	}
}
