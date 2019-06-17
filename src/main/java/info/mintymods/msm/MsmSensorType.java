package info.mintymods.msm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;

import info.mintymods.mss.utils.MssJSONUtils;

public enum MsmSensorType {
	NONE(0, "None"), TEMP(1, "Temperatures"), VOLT(2, "Voltages"), FAN(3, "Fans"), CURRENT(4, "Currents"),
	POWER(5, "Power"), CLOCK(6, "Clocks"), USAGE(7, "Usages"), OTHER(8, "Other");

	private int type = 8;
	private String desc;

	MsmSensorType(int type, String desc) {
		this.type = type;
		this.desc = desc;
	}

	@JsonProperty("type")
	public int getType() {
		return this.type;
	}

	@JsonProperty("desc")
	public String getDesc() {
		return desc;
	}

	@JsonProperty("desc")
	public void setDesc(String desc) {
		this.desc = desc;
	}

	@JsonProperty("type")
	public void setType(int type) {
		this.type = type;
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
