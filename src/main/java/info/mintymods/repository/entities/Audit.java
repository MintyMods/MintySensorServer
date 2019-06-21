package info.mintymods.repository.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Audit {

	@Temporal(TemporalType.DATE)
	@Column(name = "date_created", nullable = false)
	private Date date_created;
	@Column(name = "date_updated", nullable = false)
	private Date date_amended;
	private String who_created;
	private String who_amended;

	public Date getDate_amended() {
		return date_amended;
	}

	public Date getDate_created() {
		return date_created;
	}

	public String getWho_amended() {
		return who_amended;
	}

	public String getWho_created() {
		return who_created;
	}

	public void setDate_amended(Date date_amended) {
		this.date_amended = date_amended;
	}

	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}

	public void setWho_amended(String who_amended) {
		this.who_amended = who_amended;
	}

	public void setWho_created(String who_created) {
		this.who_created = who_created;
	}
}
