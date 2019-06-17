package info.mintymods.mss.webapp.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class SignupForm {

	@NotEmpty(message = "{validation.userId.NotEmpty}")
	@Pattern(regexp = "^[a-zA-Z]{1}[a-zA-Z0-9_]{3,20}$", message = "{validation.userId.Pattern}")
	private String userId;

	@NotEmpty(message = "{validation.name.NotEmpty}")
	private String name;

	@NotEmpty(message = "{validation.email.NotEmpty}")
	@Email(message = "{validation.email.Email}")
	private String email;

	@NotEmpty(message = "{validation.password.NotEmpty}")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=])(?=\\S+$).{8,20}$", message = "{validation.password.Pattern}")
	private String password;

	public String getUserId() { return this.userId; }

	public String getName() { return this.name; }

	public String getEmail() { return this.email; }

	public String getPassword() { return this.password; }

	public void setUserId(final String userId) { this.userId = userId; }

	public void setName(final String name) { this.name = name; }

	public void setEmail(final String email) { this.email = email; }

	public void setPassword(final String password) { this.password = password; }

	@java.lang.Override
	public java.lang.String toString() {
		return "SignupForm(userId=" + this.getUserId() + ", name=" + this.getName() + ", email=" + this.getEmail()
				+ ", password=" + this.getPassword() + ")";
	}

	public SignupForm() {
	}

	public SignupForm(final String userId, final String name, final String email, final String password) {
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
	}
}
