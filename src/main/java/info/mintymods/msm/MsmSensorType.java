package info.mintymods.msm;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;

import info.mintymods.utils.MintyJsonUtils;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum MsmSensorType {
	NONE(0, "None", "fal fa-times-circle"), TEMP(1, "Temperatures", "fal fa-thermometer-half"), VOLT(2, "Voltages", "fal fa-bolt"), FAN(3, "Fans", "fal fa-fan"), CURRENT(4,
			"Currents", "fal fa-wave-square"), POWER(5, "Power",
					"fal fa-car-battery"), CLOCK(6, "Clocks", "far fa-clock"), USAGE(7, "Usages", "fal fa-chart-pie"), OTHER(8, "Other", "fal fa-share-alt");

	private int type = 8;
	private String desc;
	private String icon;

	MsmSensorType(final int type, final String desc, final String icon) {
		this.type = type;
		this.desc = desc;
		this.icon = icon;
	}

	@JsonProperty("desc")
	public String getDesc() {
		return desc;
	}

	@JsonProperty("icon")
	public String getIcon() {
		return icon;
	}

	@JsonProperty("type")
	public int getType() {
		return type;
	}

	@JsonProperty("desc")
	public void setDesc(final String desc) {
		this.desc = desc;
	}

	@JsonProperty("icon")
	public void setIcon(final String icon) {
		this.icon = icon;
	}

	@JsonProperty("type")
	public void setType(final int type) {
		this.type = type;
	}

	@JsonCreator
	public static MsmSensorType fromJson(@JsonProperty("name") final String name) {
		MsmSensorType sensorType;
		try {
			sensorType = MsmSensorType.values()[Integer.parseInt(name)];
		} catch (final NumberFormatException nfe) {
			sensorType = MsmSensorType.valueOf(name);
		}
		return sensorType;
	}

	@JsonProperty
	public String getName() {
		return super.name();
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
