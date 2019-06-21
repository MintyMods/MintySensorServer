package info.mintymods.repository.entities.enums;

public enum ViewType {
	ADMIN("Admin", "fas fa-user-lock"), SETTINGS("Settings", "fas fa-user-lock"), TV("T.V.", "fas fa-tv"), PC("P.C.", "fas fa-laptopv"), PHONE("Phone", "fas fa-mobile-alt");

	private String desc;
	private String icon;

	ViewType(String desc, String icon) {
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
