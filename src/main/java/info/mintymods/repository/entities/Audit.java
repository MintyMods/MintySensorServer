package info.mintymods.repository.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "minty_audit")
public class Audit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "minty_audit_gen")
	@SequenceGenerator(name = "minty_audit_gen", sequenceName = "MINTY_AUDIT_SEQ")
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	private Date createdDate;
	private String createdUser;
	private Date amendedDate;
	private String amendedUser;

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	public String getAmendedUser() {
		return amendedUser;
	}

	public void setAmendedUser(String amendedUser) {
		this.amendedUser = amendedUser;
	}

	public Date getAmendedDate() {
		return amendedDate;
	}

	public void setAmendedDate(Date amendedDate) {
		this.amendedDate = amendedDate;
	}
}
