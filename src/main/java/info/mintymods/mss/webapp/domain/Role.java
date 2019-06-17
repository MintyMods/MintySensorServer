package info.mintymods.mss.webapp.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String roleName;

	@Column(nullable = false)
	private String description;

	@CreationTimestamp
	@Column
	private LocalDateTime createdDate;

	@UpdateTimestamp
	@Column
	private LocalDateTime updatedDate;

	public Role() {
	}

	public Long getId() { return this.id; }

	public String getRoleName() { return this.roleName; }

	public String getDescription() { return this.description; }

	public LocalDateTime getCreatedDate() { return this.createdDate; }

	public LocalDateTime getUpdatedDate() { return this.updatedDate; }

	public void setId(final Long id) { this.id = id; }

	public void setRoleName(final String roleName) { this.roleName = roleName; }

	public void setDescription(final String description) { this.description = description; }

	public void setCreatedDate(final LocalDateTime createdDate) { this.createdDate = createdDate; }

	public void setUpdatedDate(final LocalDateTime updatedDate) { this.updatedDate = updatedDate; }

	@java.lang.Override
	public java.lang.String toString() {
		return "Role(id=" + this.getId() + ", roleName=" + this.getRoleName() + ", description=" + this.getDescription()
				+ ", createdDate=" + this.getCreatedDate() + ", updatedDate=" + this.getUpdatedDate() + ")";
	}

}
