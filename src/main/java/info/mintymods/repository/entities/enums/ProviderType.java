package info.mintymods.repository.entities.enums;

public enum ProviderType {

	HWINFO("HWiNFO", ProtocolType.HTTPS, "www.hwinfo.com", "fas fa-info"),
	GPUZ("GPU-Z", ProtocolType.HTTPS,"www.techpowerup.com/gpuz/", "fas fa-user-shield"), 
	OHM("Open Hardware Monitor", ProtocolType.HTTPS, "openhardwaremonitor.org", "fas fa-microchip");

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

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getName() {
		return getName();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ProtocolType getProtocol() {
		return protocol;
	}

	public void setProtocol(ProtocolType protocol) {
		this.protocol = protocol;
	}
}
