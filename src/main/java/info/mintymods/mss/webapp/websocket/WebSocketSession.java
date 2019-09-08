package info.mintymods.mss.webapp.websocket;

public class WebSocketSession {

	private String sessionId;
	private String destination;
	private WebSocketInstruction message;

	public WebSocketSession(final String sessionId, final String destination) {
		this.sessionId = sessionId;
		this.destination = destination;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(final String session) {
		sessionId = session;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(final String destination) {
		this.destination = destination;
	}

	public WebSocketInstruction getMessage() {
		return message;
	}

	public void setMessage(final WebSocketInstruction message) {
		this.message = message;
	}
}
