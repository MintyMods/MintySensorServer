package info.mintymods.mss.webapp.websocket;

import info.mintymods.msm.MsmSensor;
import info.mintymods.msm.MsmSensorType;
import info.mintymods.utils.MintyJsonUtils;

public class WebSocketInstruction {

	WebSocketCommand command = WebSocketCommand.PING;
	private String channel = "";
	private String json = "";
	private MsmSensor sensor;
	// @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	// private List<String> parameters = new ArrayList<>();
	private Object parameters;
	private MsmSensorType type;

	public WebSocketInstruction() {
	}

	public WebSocketInstruction(final Object json) {
		this.json = MintyJsonUtils.getJsonString(json);
	}

	public WebSocketCommand getCommand() {
		return command;
	}

	public void setCommand(final WebSocketCommand command) {
		this.command = command;
	}

	public String getJson() {
		return json;
	}

	public void setJson(final Object json) {
		this.json = MintyJsonUtils.getJsonString(json);
	}

	public Object getParameters() {
		return parameters;
	}

	public void setParameters(final Object parameters) {
		this.parameters = parameters;
	}

	// public String getParameter(final String name) {
	// final int index = parameters.indexOf(name);
	// if (index > -1) {
	// return parameters.get(index);
	// }
	// return null;
	// }
	public MsmSensor getSensor() {
		return sensor;
	}

	public void setSensor(final MsmSensor sensor) {
		this.sensor = sensor;
	}

	public MsmSensorType getType() {
		return type;
	}

	public void setType(final MsmSensorType type) {
		this.type = type;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(final String channel) {
		this.channel = channel;
	}
}