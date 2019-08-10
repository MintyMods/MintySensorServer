package info.mintymods.repository.entities.audit;

import java.util.Date;

// @Entity
// @Table(name = "minty_audit_created")
public class Created {

	// @Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	// @Column(name = "id", updatable = false, nullable = false)
	// private Long id;
	private final Date date = new Date();
	private String user;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}
}