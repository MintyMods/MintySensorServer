package info.mintymods.repository.entities.enums;

public enum ProtocolType {
	HTTP("http://", "fal fa-user-times"), HTTPS("https://", "fal fa-user-shield");

	private String desc;
	private String icon;

	ProtocolType(String desc, String icon) {
		setDesc(desc);
		setIcon(icon);
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

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
}
