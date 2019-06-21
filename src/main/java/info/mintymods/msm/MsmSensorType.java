package info.mintymods.msm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;

import info.mintymods.utils.MintyJsonUtils;

public enum MsmSensorType {
	
	NONE(0, "None", "far fa-times-circle"), 
	TEMP(1, "Temperatures", "fas fa-thermometer-half"), 
	VOLT(2, "Voltages",	"fas fa-bolt"), 
	FAN(3, "Fans", "fas fa-fan"), 
	CURRENT(4, "Currents", "fas fa-wave-square"), 
	POWER(5, "Power", "fas fa-car-battery"), 
	CLOCK(6, "Clocks", "far fa-clock"), 
	USAGE(7, "Usages", "fas fa-chart-pie"), 
	OTHER(8, "Other", "fas fa-share-alt");

	private int type = 8;
	private String desc;
	private String icon;

	MsmSensorType(int type, String desc, String icon) {
		this.type = type;
		this.desc = desc;
		this.icon = icon;
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

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getName() {
		return this.name();
	}

	@Override
	public String toString() {
		try {
			return MintyJsonUtils.getMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

}
