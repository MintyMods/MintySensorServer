package info.mintymods.repository.entities.audit;

import java.util.Date;

// @Entity
// @Table(name = "minty_audit_amended")
public class Amended {

	// @Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	// @Column(name = "id", updatable = false, nullable = false)
	// private Long id;
	private Date amendedDate;
	private String amendedUser;
}
