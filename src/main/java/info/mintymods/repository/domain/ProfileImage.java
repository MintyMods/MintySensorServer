package info.mintymods.repository.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners({AuditingEntityListener.class})
public class ProfileImage {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	private String fileName;
	private String fileType;
	private long size;
	private long width;
	private long height;

	@CreatedDate
	@Column
	private LocalDateTime createdDate;

	@LastModifiedDate
	@Column
	private LocalDateTime updatedDate;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "profile_id", nullable = false, foreignKey = @ForeignKey(name = "FK_profile_image_profile"))
	private Profile profile;

	public ProfileImage() {
	}

	public String getId() {
		return this.id;
	}

	public String getFileName() {
		return this.fileName;
	}

	public String getFileType() {
		return this.fileType;
	}

	public long getSize() {
		return this.size;
	}

	public long getWidth() {
		return this.width;
	}

	public long getHeight() {
		return this.height;
	}

	public LocalDateTime getCreatedDate() {
		return this.createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return this.updatedDate;
	}

	public Profile getProfile() {
		return this.profile;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public void setFileName(final String fileName) {
		this.fileName = fileName;
	}

	public void setFileType(final String fileType) {
		this.fileType = fileType;
	}

	public void setSize(final long size) {
		this.size = size;
	}

	public void setWidth(final long width) {
		this.width = width;
	}

	public void setHeight(final long height) {
		this.height = height;
	}

	public void setCreatedDate(final LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public void setUpdatedDate(final LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public void setProfile(final Profile profile) {
		this.profile = profile;
	}

	@java.lang.Override
	public java.lang.String toString() {
		return "ProfileImage(id=" + this.getId() + ", fileName=" + this.getFileName() + ", fileType="
				+ this.getFileType() + ", size=" + this.getSize() + ", width=" + this.getWidth() + ", height="
				+ this.getHeight() + ", createdDate=" + this.getCreatedDate() + ", updatedDate=" + this.getUpdatedDate()
				+ ", profile=" + this.getProfile() + ")";
	}
}
