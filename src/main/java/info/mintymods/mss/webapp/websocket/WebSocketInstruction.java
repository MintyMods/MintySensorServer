package info.mintymods.mss.webapp.websocket;

import info.mintymods.msm.MsmSensorType;

public class WebSocketInstruction {

	private MsmSensorType type;
	private String content;
	private String sender;

	public MsmSensorType getType() {
		return type;
	}

	public void setType(final MsmSensorType type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(final String content) {
		this.content = content;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(final String sender) {
		this.sender = sender;
	}
}