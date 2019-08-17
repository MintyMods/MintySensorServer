package info.mintymods.msm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;

import info.mintymods.utils.MintyJsonUtils;

public class MsmSensor {

	private Long id;
	private int instance;
	private MsmSensorLabel label;

	@JsonProperty("id")
	public Long getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Long id) {
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
			return MintyJsonUtils.getMapper().writeValueAsString(this);
		} catch (final JsonProcessingException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
}
