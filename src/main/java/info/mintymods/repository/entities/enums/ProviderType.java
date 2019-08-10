package info.mintymods.repository.entities.enums;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "minty_provider_type")
public enum ProviderType {
	HWINFO("HWiNFO", ProtocolType.HTTPS, "www.hwinfo.com", "fal fa-info"), GPUZ("GPU-Z", ProtocolType.HTTPS, "www.techpowerup.com/gpuz/",
			"fal fa-user-shield"), OHM("Open Hardware Monitor", ProtocolType.HTTPS, "openhardwaremonitor.org", "fal fa-microchip");

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "minty_provider_type_gen")
	@SequenceGenerator(name = "minty_provider_type_gen", sequenceName = "MINTY_PROVIDER_TYPE_SEQ")
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	private String desc;
	private String url;
	private ProtocolType protocol;
	private String icon;

	ProviderType(String desc, ProtocolType protocol, String url, String icon) {
		this.desc = desc;
		this.protocol = protocol;
		this.url = url;
		this.icon = icon;
	}

	public String getDesc() {
		return desc;
	}

	public String getIcon() {
		return icon;
	}

	public String getName() {
		return toString();
	}

	public ProtocolType getProtocol() {
		return protocol;
	}

	public String getUrl() {
		return url;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public void setProtocol(ProtocolType protocol) {
		this.protocol = protocol;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
