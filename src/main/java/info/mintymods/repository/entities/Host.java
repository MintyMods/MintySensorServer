package info.mintymods.repository.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import info.mintymods.repository.entities.enums.HostType;
import info.mintymods.repository.entities.enums.ProtocolType;

@Entity
@Table(name = "minty_host")
public class Host extends BaseEntity {

	private final static String ICON = "fal fa-network-wired";
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;
	@NotBlank(message = "HostType is mandatory")
	private HostType type;
	@NotBlank(message = "Protocol is mandatory")
	private ProtocolType protocol;
	@NotBlank(message = "Port is mandatory")
	private int port;

	public Host() {
	}

	public Host(Long id, HostType type, ProtocolType protocol, int port, Label label) {
		this.id = id;
		this.type = type;
		this.protocol = protocol;
		this.port = port;
		this.label = label;
	}

	public String getIcon() {
		return ICON;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
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

	@Override
	public boolean isActive() {
		return active;
	}

	@Override
	public void setActive(boolean active) {
		this.active = active;
	}

	public void setHostType(HostType type) {
		this.type = type;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
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
}
