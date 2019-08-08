package info.mintymods.repository.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "minty_audit")
public class Audit {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "id", nullable = false)
	private Long id;
	private Date dateCreated = new Date();
	private Date dateAmended;
	private String whoCreated;
	private String whoAmended;

	public Long getId() {
		return id;
	}

	public Date getDate_amended() {
		return dateAmended;
	}

	public Date getDate_created() {
		return dateCreated;
	}

	public String getWho_amended() {
		return whoAmended;
	}

	public String getWho_created() {
		return whoCreated;
	}

	public void setDate_amended(Date date_amended) {
		dateAmended = date_amended;
	}

	public void setDate_created(Date date_created) {
		dateCreated = date_created;
	}

	public void setWho_amended(String who_amended) {
		whoAmended = who_amended;
	}

	public void setWho_created(String who_created) {
		whoCreated = who_created;
	}
}
