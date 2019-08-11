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

	@JsonProperty("avg")
	public double getAvg() {
		return avg;
	}

	@JsonProperty("id")
	public int getId() {
		return id;
	}

	@JsonProperty("sensor_index")
	public int getIndex() {
		return sensor_index;
	}

	@JsonProperty("label")
	public MsmSensorLabel getLabel() {
		return label;
	}

	@JsonProperty("max")
	public double getMax() {
		return max;
	}

	@JsonProperty("min")
	public double getMin() {
		return min;
	}

	@JsonProperty("type")
	public MsmSensorType getType() {
		return type;
	}

	@JsonProperty("unit")
	public String getUnit() {
		return unit;
	}

	@JsonProperty("value")
	public double getValue() {
		return value;
	}

	@JsonProperty("avg")
	public void setAvg(double avg) {
		this.avg = avg;
	}

	@JsonProperty("id")
	public void setId(int id) {
		this.id = id;
	}

	@JsonProperty("sensor_index")
	public void setIndex(int index) {
		sensor_index = index;
	}

	@JsonProperty("label")
	public void setLabel(MsmSensorLabel label) {
		this.label = label;
	}

	@JsonProperty("max")
	public void setMax(double max) {
		this.max = max;
	}

	@JsonProperty("min")
	public void setMin(double min) {
		this.min = min;
	}

	@JsonProperty("type")
	public void setType(MsmSensorType type) {
		this.type = type;
	}

	@JsonProperty("unit")
	public void setUnit(String unit) {
		this.unit = unit;
	}

	@JsonProperty("value")
	public void setValue(double value) {
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
}
