package info.mintymods.repository.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.envers.Audited;

import info.mintymods.repository.entities.enums.HostType;
import info.mintymods.repository.entities.enums.ProtocolType;

@Audited
@Entity
@Table(name = "minty_host")
public class Host {

	public static final String ICON = "fal fa-network-wired";
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "minty_host_gen")
	@SequenceGenerator(name = "minty_host_gen", sequenceName = "MINTY_HOST_SEQ")
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@NotBlank(message = "HostType is mandatory")
	private HostType type;
	@NotBlank(message = "Protocol is mandatory")
	private ProtocolType protocol;
	@NotBlank(message = "Port is mandatory")
	private int port;

	public Host() {
	}

	public Host(Long id, HostType type, ProtocolType protocol, int port) {
		this.setId(id);
		this.type = type;
		this.protocol = protocol;
		this.port = port;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
