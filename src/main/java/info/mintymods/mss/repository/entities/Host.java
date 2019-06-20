package info.mintymods.mss.repository.entities;

public class Host {

	private String label;
	private String name;
	private String protocol;
	private String port;
	private boolean active;

	public Host() {
	}

	public Host(String label, String name, String protocol, String port, boolean active) {
		this.label = label;
		this.name = name;
		this.protocol = protocol;
		this.port = port;
		this.active = active;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
