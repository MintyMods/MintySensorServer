package info.mintymods.repository.entities;

import info.mintymods.repository.entities.enums.HostType;
import info.mintymods.repository.entities.enums.ProtocolType;

public class Host {

	private int id;
	private HostType type;
	private ProtocolType protocol;
	private int port;
	private Label label;
	private boolean active;

	public Host() { }

	public Host(int id, HostType type, ProtocolType protocol, int port, Label label) {
		this.id = id;
		this.type = type;
		this.protocol = protocol;
		this.port = port;
		this.label = label;
		this.active = true;
	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	public HostType getType() {
		return type;
	}

	public void setHostType(HostType type) {
		this.type = type;
	}

	public ProtocolType getProtocol() {
		return protocol;
	}

	public void setProtocol(ProtocolType protocol) {
		this.protocol = protocol;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
