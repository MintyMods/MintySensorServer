package info.mintymods.mss.webapp.enums;

public enum Role {
	// ADMIN
	ROLE_ADMIN("ROLE_ADMIN");

//    @Getter
	private String name;

	Role(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
