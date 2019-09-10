package info.mintymods.mss.webapp.websocket;

import java.beans.ConstructorProperties;

public enum WebSocketCommand {
	EVENTS("EVENTS"), PING("PING"), SENSORS("SENSORS"), READINGS_BY_SENSOR("READINGS_BY_SENSOR"), TYPES("TYPES"), READINGS_BY_TYPE("TYPE_READINGS");

	private String command;

	@ConstructorProperties({"command"})
	private WebSocketCommand(final String command) {
		this.command = command;
	}

	public String getCommand() {
		return command;
	}
}
