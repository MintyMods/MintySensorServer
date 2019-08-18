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

	public String getSource() {
		return source;
	}

	public String getType() {
		return type;
	}

	public boolean isDebug() {
		return debug;
	}

	@JsonProperty("debug")
	public void setDebug(final boolean debug) {
		this.debug = debug;
	}

	@JsonProperty("source")
	public void setSource(final String source) {
		this.source = source;
	}

	@JsonProperty("type")
	public void setType(final String type) {
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
