package info.mintymods.mss.webapp.websocket;

public class WebSocketInstruction {

	private MessageType type;
	private String content;
	private String sender;

	public enum MessageType {
		CHAT, JOIN, LEAVE
	}

	public MessageType getType() {
		return type;
	}

	public void setType(final MessageType type) {
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