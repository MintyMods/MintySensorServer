package info.mintymods.repository.entities.enums;

public enum ViewType {
	ADMIN("Admin", "fal fa-user-lock"), SETTINGS("Settings", "fal fa-user-lock"), TV("T.V.", "fal fa-tv"), PC("P.C.", "fal fa-laptopv"), PHONE("Phone", "fal fa-mobile-alt");

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
