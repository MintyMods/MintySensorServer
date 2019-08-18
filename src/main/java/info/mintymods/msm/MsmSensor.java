package info.mintymods.msm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;

import info.mintymods.utils.MintyJsonUtils;

public class MsmSensor {

	private Long id;
	private int instance;
	private MsmSensorLabel label;

	public Long getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(final Long id) {
		this.id = id;
	}

	public int getInstance() {
		return instance;
	}

	@JsonProperty("instance")
	public void setInstance(final int instance) {
		this.instance = instance;
	}

	public MsmSensorLabel getLabel() {
		return label;
	}

	@JsonProperty("label")
	public void setLabel(final MsmSensorLabel label) {
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
