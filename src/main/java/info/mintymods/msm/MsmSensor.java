package info.mintymods.msm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;

import info.mintymods.mss.utils.MssJSONUtils;

public class MsmSensor {

	private String id;
	private int instance;
	private String name;
	private MsmSensorLabel label;

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("instance")
	public int getInstance() {
		return instance;
	}

	@JsonProperty("instance")
	public void setInstance(int instance) {
		this.instance = instance;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("label")
	public MsmSensorLabel getLabel() {
		return label;
	}

	@JsonProperty("label")
	public void setLabel(MsmSensorLabel label) {
		this.label = label;
	}

	@Override
	public String toString() {
		try {
			return MssJSONUtils.getMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

}
