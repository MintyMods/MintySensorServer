package info.mintymods.msm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;

import info.mintymods.utils.MintyJsonUtils;

public class MsmSensorLabel {

	private String name;
	private String desc;

	public MsmSensorLabel() {
	}

	public MsmSensorLabel(final String name, final String desc) {
		this.name = name;
		this.desc = desc;
	}

	public String getName() {
		return name;
	}

	@JsonProperty("value")
	public void setName(final String name) {
		this.name = name;
	}

	public String getDescription() {
		return desc;
	}

	@JsonProperty("desc")
	public void setDescription(final String desc) {
		this.desc = desc;
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
