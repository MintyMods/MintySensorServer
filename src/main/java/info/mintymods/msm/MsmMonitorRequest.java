package info.mintymods.msm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;

import info.mintymods.utils.MintyJsonUtils;

public class MsmMonitorRequest {

	private String source = "MSM[JSON]HWiNFO";
	private String type;
	private boolean debug = false;

	public MsmMonitorRequest() {
		type = getClass().getName();
	}

	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@JsonProperty("source")
	public String getSource() {
		return source;
	}

	@JsonProperty("source")
	public void setSource(String source) {
		this.source = source;
	}

	@JsonProperty("debug")
	public boolean isDebug() {
		return debug;
	}

	@JsonProperty("debug")
	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
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
