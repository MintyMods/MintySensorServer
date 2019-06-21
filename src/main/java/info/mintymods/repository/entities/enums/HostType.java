package info.mintymods.repository.entities.enums;

public enum HostType {

	LOCALHOST("Localhost", "fas fa-home"), 
	REMOTEHOST("Remote", "fas fa-project-diagram");

	private String desc;
	private String icon;

	HostType(String desc, String icon) {
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
