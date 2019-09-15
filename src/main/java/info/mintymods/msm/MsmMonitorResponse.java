package info.mintymods.msm;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;

import info.mintymods.msm.exception.MsmException;
import info.mintymods.utils.MintyJsonUtils;

public class MsmMonitorResponse {

	private List<MsmSensor> sensors = new ArrayList<>();
	private List<MsmSensorReading> readings = new ArrayList<>();
	private List<String> labels = new ArrayList<>();
	private String source;
	private MsmMonitorRequest request;
	private MsmException exception;
	private String version;
	private String type;
	private boolean debug;
	private String time_taken;
	private Long polling_period;

	public MsmMonitorResponse() {
		type = getClass().getName();
	}

	public MsmException getException() {
		return exception;
	}

	public List<String> getLabels() {
		return labels;
	}

	public List<MsmSensorReading> getReadings() {
		return readings;
	}

	public MsmMonitorRequest getRequest() {
		return request;
	}

	public List<MsmSensor> getSensors() {
		return sensors;
	}

	public String getSource() {
		return source;
	}

	public String getTime_taken() {
		return time_taken;
	}

	public String getType() {
		return type;
	}

	public String getVersion() {
		return version;
	}

	public boolean isDebug() {
		return debug;
	}

	@JsonProperty("debug")
	public void setDebug(final boolean debug) {
		this.debug = debug;
	}

	@JsonProperty("exception")
	public void setException(final MsmException exception) {
		this.exception = exception;
	}

	@JsonProperty("labels")
	public void setNames(final List<String> labels) {
		this.labels = labels;
	}

	@JsonProperty("readings")
	public void setReadings(final List<MsmSensorReading> readings) {
		this.readings = readings;
	}

	@JsonProperty("request")
	public void setRequest(final MsmMonitorRequest request) {
		this.request = request;
	}

	@JsonProperty("sensors")
	public void setSensors(final List<MsmSensor> sensors) {
		this.sensors = sensors;
	}

	@JsonProperty("source")
	public void setSource(final String source) {
		this.source = source;
	}

	@JsonProperty("time_taken")
	public void setTime_taken_ms(final String time_taken) {
		this.time_taken = time_taken;
	}

	@JsonProperty("type")
	public void setType(final String type) {
		this.type = type;
	}

	@JsonProperty("version")
	public void setVersion(final String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		try {
			return MintyJsonUtils.getMapper().writeValueAsString(this);
		} catch (final JsonProcessingException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public Long getPolling_period() {
		return polling_period;
	}

	@JsonProperty("polling_period")
	public void setPolling_period(final Long polling_period) {
		this.polling_period = polling_period;
	}
}
