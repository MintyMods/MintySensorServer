package info.mintymods.mss.webapp.enums;

public enum MessageKey {
	VALIDATION_FAILED("message.validation.failed"),

	ADMIN_ALREADY_CREATED("message.signup.failed.admin.already.created"),
	ADMIN_CREATE_ERROR("message.signup.failed.admin.create.error"),
	ADMIN_CREATED_SUCCESSFULLY("message.signup.admin.created.successfully"),
	ADMIN_ROLE_NOT_FOUND("message.signup.admin.role.not.found"), PASSWORD_EMPTY("message.signup.password.empty");

	private String key;

	MessageKey(String key) {
		this.setKey(key);
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
