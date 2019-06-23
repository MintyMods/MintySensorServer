package info.mintymods.repository.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import info.mintymods.repository.entities.enums.HostType;
import info.mintymods.repository.entities.enums.ProtocolType;

@Entity
@Table(name = "hosts")
public class Host extends Audit {

	private final static String ICON = "fal fa-network-wired";

	public static String getIcon() {
		return ICON;
	}

	@Version
	private int version;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;
	private boolean active = true;
	private HostType type;
	private ProtocolType protocol;
	private int port;
	private Label label;

	public Host() {
	}

	public Host(Long id, HostType type, ProtocolType protocol, int port, Label label) {
		this.id = id;
		this.type = type;
		this.protocol = protocol;
		this.port = port;
		this.label = label;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) { return true; }
		if (obj == null) { return false; }
		if (getClass() != obj.getClass()) { return false; }
		final Host other = (Host) obj;
		if (active != other.active) { return false; }
		if (id == null) {
			if (other.id != null) { return false; }
		} else
			if (!id.equals(other.id)) { return false; }
		if (label == null) {
			if (other.label != null) { return false; }
		} else
			if (!label.equals(other.label)) { return false; }
		if (port != other.port) { return false; }
		if (protocol != other.protocol) { return false; }
		if (type != other.type) { return false; }
		if (version != other.version) { return false; }
		return true;
	}

	public Long getId() {
		return id;
	}

	public Label getLabel() {
		return label;
	}

	public int getPort() {
		return port;
	}

	public ProtocolType getProtocol() {
		return protocol;
	}

	public HostType getType() {
		return type;
	}

	public int getVersion() {
		return version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + (active ? 1231 : 1237);
		result = (prime * result) + ((id == null) ? 0 : id.hashCode());
		result = (prime * result) + ((label == null) ? 0 : label.hashCode());
		result = (prime * result) + port;
		result = (prime * result) + ((protocol == null) ? 0 : protocol.hashCode());
		result = (prime * result) + ((type == null) ? 0 : type.hashCode());
		result = (prime * result) + version;
		return result;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setHostType(HostType type) {
		this.type = type;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setProtocol(ProtocolType protocol) {
		this.protocol = protocol;
	}

	public void setType(HostType type) {
		this.type = type;
	}

	public void setVersion(int version) {
		this.version = version;
	}
}
