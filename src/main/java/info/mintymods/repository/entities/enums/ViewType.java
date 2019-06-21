package info.mintymods.repository.entities.enums;

public enum ViewType {

	TV("T.V.", "fas fa-tv"), 
	PC("P.C.", "fas fa-laptopv"),
	PHONE("Phone", "fas fa-mobile-alt");

	private String desc;
	private String icon;

	ViewType(String desc, String icon) {
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
