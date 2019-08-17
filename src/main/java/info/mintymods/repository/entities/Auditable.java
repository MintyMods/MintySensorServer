package info.mintymods.repository.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
abstract class Auditable<User> {

	@CreatedBy
	@Column(nullable = false, updatable = false)
	private String createdBy;
	@CreatedDate
	@Column(nullable = false, updatable = false)
	private LocalDateTime created;
	@LastModifiedBy
	@Column(nullable = false)
	private String modifiedBy;
	@LastModifiedDate
	@Column(nullable = false)
	private LocalDateTime modified;
	@Column(nullable = false)
	@NotBlank(message = "username is required")
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public LocalDateTime getModified() {
		return modified;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}
}