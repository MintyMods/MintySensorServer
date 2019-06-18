package info.mintymods.msm;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;

import info.mintymods.utils.MintyJsonUtils;

public class MsmMonitorResponse {

	private List<MsmSensor> sensors = new ArrayList<MsmSensor>();
	private List<MsmSensorReading> readings = new ArrayList<MsmSensorReading>();
	private List<String> labels = new ArrayList<String>();
	private String source;
	private MsmMonitorRequest request;
	private MsmException exception;
	private String version;
	private String type;
	private boolean debug;
	private long time_taken_ms;

	public MsmMonitorResponse() {
		type = getClass().getName();
	}

	@JsonProperty("source")
	public String getSource() {
		return source;
	}

	@JsonProperty("request")
	public MsmMonitorRequest getRequest() {
		return request;
	}

	@JsonProperty("labels")
	public List<String> getLabels() {
		return labels;
	}

	@JsonProperty("sensors")
	public List<MsmSensor> getSensors() {
		return sensors;
	}

	@JsonProperty("exception")
	public MsmException getException() {
		return exception;
	}

	@JsonProperty("version")
	public String getVersion() {
		return version;
	}

	@JsonProperty("debug")
	public boolean isDebug() {
		return debug;
	}

	@JsonProperty("time_taken_ms")
	public long getTime_taken_ms() {
		return time_taken_ms;
	}

	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@JsonProperty("readings")
	public List<MsmSensorReading> getReadings() {
		return readings;
	}

	@JsonProperty("readings")
	public void setReadings(List<MsmSensorReading> readings) {
		this.readings = readings;
	}

	@JsonProperty("source")
	public void setSource(String source) {
		this.source = source;
	}

	@JsonProperty("request")
	public void setRequest(MsmMonitorRequest request) {
		this.request = request;
	}

	@JsonProperty("labels")
	public void setNames(List<String> labels) {
		this.labels = labels;
	}

	@JsonProperty("sensors")
	public void setSensors(List<MsmSensor> sensors) {
		this.sensors = sensors;
	}

	@JsonProperty("exception")
	public void setException(MsmException exception) {
		this.exception = exception;
	}

	@JsonProperty("version")
	public void setVersion(String version) {
		this.version = version;
	}

	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}

	@JsonProperty("debug")
	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	@JsonProperty("time_taken_ms")
	public void setTime_taken_ms(long time_taken_ms) {
		this.time_taken_ms = time_taken_ms;
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
