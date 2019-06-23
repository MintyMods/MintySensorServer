package info.mintymods.msm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;

import info.mintymods.utils.MintyJsonUtils;

public enum MsmSensorType {
	NONE(0, "None", "fal fa-times-circle"), TEMP(1, "Temperatures", "fal fa-thermometer-half"), VOLT(2, "Voltages", "fal fa-bolt"), FAN(3, "Fans", "fal fa-fan"), CURRENT(4,
			"Currents", "fal fa-wave-square"), POWER(5, "Power",
					"fal fa-car-battery"), CLOCK(6, "Clocks", "far fa-clock"), USAGE(7, "Usages", "fal fa-chart-pie"), OTHER(8, "Other", "fal fa-share-alt");

	private int type = 8;
	private String desc;
	private String icon;

	MsmSensorType(int type, String desc, String icon) {
		this.type = type;
		this.desc = desc;
		this.icon = icon;
	}

	@JsonProperty("desc")
	public String getDesc() {
		return desc;
	}

	public String getIcon() {
		return icon;
	}

	public String getName() {
		return name();
	}

	@JsonProperty("type")
	public int getType() {
		return type;
	}

	@JsonProperty("desc")
	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@JsonProperty("type")
	public void setType(int type) {
		this.type = type;
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
