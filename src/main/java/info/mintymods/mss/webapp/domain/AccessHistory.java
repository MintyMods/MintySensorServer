package info.mintymods.mss.webapp.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AccessHistory {

	@Id
	@GeneratedValue
	private long id;

	@Column
	private LocalDateTime loginDate;

	@Column
	private boolean loggedIn;

	@Column
	private String comment;

	@ManyToOne
	@JoinColumn(name = "account_id", foreignKey = @ForeignKey(name = "FK_account_access_history"))
	private Account account;

	public AccessHistory() {
	}

	public long getId() { return this.id; }

	public LocalDateTime getLoginDate() { return this.loginDate; }

	public boolean isLoggedIn() { return this.loggedIn; }

	public String getComment() { return this.comment; }

	public Account getAccount() { return this.account; }

	public void setId(final long id) { this.id = id; }

	public void setLoginDate(final LocalDateTime loginDate) { this.loginDate = loginDate; }

	public void setLoggedIn(final boolean loggedIn) { this.loggedIn = loggedIn; }

	public void setComment(final String comment) { this.comment = comment; }

	public void setAccount(final Account account) { this.account = account; }

	@java.lang.Override
	public java.lang.String toString() {
		return "AccessHistory(id=" + this.getId() + ", loginDate=" + this.getLoginDate() + ", loggedIn="
				+ this.isLoggedIn() + ", comment=" + this.getComment() + ", account=" + this.getAccount() + ")";
	}
}
