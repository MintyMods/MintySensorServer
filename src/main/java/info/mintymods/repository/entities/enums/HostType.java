package info.mintymods.repository.entities.enums;

public enum HostType {
	LOCALHOST("Local Host", "fal fa-home"), REMOTEHOST("Remote Host", "fal fa-project-diagram");

	private String desc;
	private String icon;

	HostType(String desc, String icon) {
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
