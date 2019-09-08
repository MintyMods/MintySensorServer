package info.mintymods.mss.webapp.websocket;

public enum WebSocketCommand {
	PING("ping"), SENSORS("sensors"), SENSOR_READINGS("sensor_readings"), TYPES("types"), TYPE_READINGS("type_readings");

	private String command;

	private WebSocketCommand(final String command) {
		this.command = command;
	}

	public String getCommand() {
		return command;
	}
}
