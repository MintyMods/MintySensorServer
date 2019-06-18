package info.mintymods.repository.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners({AuditingEntityListener.class})
public class Account {

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false, unique = true, length = 50)
	private String userId;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private int passwordFailureCount;

	@Column
	private LocalDateTime passwordUpdatedDate;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private boolean locked;

	@Column(nullable = false)
	private boolean activated;

	@Column
	private LocalDateTime lastLogin;

	@Column
	private LocalDateTime activatedDate;

	@CreatedDate
	@Column
	private LocalDateTime createdDate;

	@LastModifiedDate
	@Column
	private LocalDateTime updatedDate;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "account_roles", joinColumns = {
			@JoinColumn(name = "account_id", referencedColumnName = "id")}, inverseJoinColumns = {
					@JoinColumn(name = "role_id", referencedColumnName = "id")})
	private List<Role> roles;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "account")
	private Profile profile;

	public Account() {
	}

	public long getId() {
		return this.id;
	}

	public String getUserId() {
		return this.userId;
	}

	public String getName() {
		return this.name;
	}

	public String getPassword() {
		return this.password;
	}

	public int getPasswordFailureCount() {
		return this.passwordFailureCount;
	}

	public LocalDateTime getPasswordUpdatedDate() {
		return this.passwordUpdatedDate;
	}

	public String getEmail() {
		return this.email;
	}

	public boolean isLocked() {
		return this.locked;
	}

	public boolean isActivated() {
		return this.activated;
	}

	public LocalDateTime getLastLogin() {
		return this.lastLogin;
	}

	public LocalDateTime getActivatedDate() {
		return this.activatedDate;
	}

	public LocalDateTime getCreatedDate() {
		return this.createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return this.updatedDate;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public Profile getProfile() {
		return this.profile;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public void setUserId(final String userId) {
		this.userId = userId;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public void setPasswordFailureCount(final int passwordFailureCount) {
		this.passwordFailureCount = passwordFailureCount;
	}

	public void setPasswordUpdatedDate(final LocalDateTime passwordUpdatedDate) {
		this.passwordUpdatedDate = passwordUpdatedDate;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public void setLocked(final boolean locked) {
		this.locked = locked;
	}

	public void setActivated(final boolean activated) {
		this.activated = activated;
	}

	public void setLastLogin(final LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}

	public void setActivatedDate(final LocalDateTime activatedDate) {
		this.activatedDate = activatedDate;
	}

	public void setCreatedDate(final LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public void setUpdatedDate(final LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public void setRoles(final List<Role> roles) {
		this.roles = roles;
	}

	public void setProfile(final Profile profile) {
		this.profile = profile;
	}

	@java.lang.Override
	public java.lang.String toString() {
		return "Account(id=" + this.getId() + ", userId=" + this.getUserId() + ", name=" + this.getName()
				+ ", password=" + this.getPassword() + ", passwordFailureCount=" + this.getPasswordFailureCount()
				+ ", passwordUpdatedDate=" + this.getPasswordUpdatedDate() + ", email=" + this.getEmail() + ", locked="
				+ this.isLocked() + ", activated=" + this.isActivated() + ", lastLogin=" + this.getLastLogin()
				+ ", activatedDate=" + this.getActivatedDate() + ", createdDate=" + this.getCreatedDate()
				+ ", updatedDate=" + this.getUpdatedDate() + ", roles=" + this.getRoles() + ", profile="
				+ this.getProfile() + ")";
	}

}
