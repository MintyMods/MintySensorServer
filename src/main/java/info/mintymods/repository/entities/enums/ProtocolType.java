package info.mintymods.repository.entities.enums;

public enum ProtocolType {

	HTTP("http://", "fas fa-user-times"), 
	HTTPS("https://", "fas fa-user-shield");

	private String desc;
	private String icon;

	ProtocolType(String desc, String icon) {
		this.setDesc(desc);
		this.setIcon(icon);
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
}
