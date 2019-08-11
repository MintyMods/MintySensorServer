package info.mintymods.repository.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.envers.Audited;

import info.mintymods.repository.entities.enums.HostType;
import info.mintymods.repository.entities.enums.ProtocolType;

@Audited
@Entity
@Table(name = "minty_host")
public class Host extends BaseEntity {

	@NotBlank(message = "HostType is mandatory")
	private HostType type;
	@NotBlank(message = "Protocol is mandatory")
	private ProtocolType protocol;
	@NotBlank(message = "Port is mandatory")
	private int port;

	public Host() {
	}

	public Host(Long recordId, HostType type, ProtocolType protocol, int port, Label label) {
		this.setRecordId(recordId);
		this.type = type;
		this.protocol = protocol;
		this.port = port;
		this.label = label;
		icon = "fal fa-network-wired";
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

	public void setHostType(HostType type) {
		this.type = type;
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
