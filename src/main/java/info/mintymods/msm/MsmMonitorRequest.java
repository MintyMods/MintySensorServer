package info.mintymods.msm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;

import info.mintymods.utils.MintyJsonUtils;

public class MsmMonitorRequest {

	private String source = "MSM[JSON]EXAMPLE";
	private String type;
	private boolean debug = false;

	public MsmMonitorRequest() {
		type = getClass().getName();
	}

	@JsonProperty("source")
	public String getSource() {
		return source;
	}

	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@JsonProperty("debug")
	public boolean isDebug() {
		return debug;
	}

	@JsonProperty("debug")
	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	@JsonProperty("source")
	public void setSource(String source) {
		this.source = source;
	}

	@JsonProperty("type")
	public void setType(String type) {
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
