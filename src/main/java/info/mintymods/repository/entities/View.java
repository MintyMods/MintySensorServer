package info.mintymods.repository.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Audited
@Entity
@Table(name = "minty_view")
public class View extends BaseEntity {

	// @Id
	// @GeneratedValue(strategy = GenerationType.AUTO, generator = "minty_view_gen")
	// @SequenceGenerator(name = "minty_view_gen", sequenceName = "MINTY_VIEW_SEQ")
	// @Column(name = "id", updatable = false, nullable = false)
	// private Long id;
	public View() {
	}

	public View(Long id, Label label) {
		this.id = id;
		this.label = label;
		icon = "fal fa-eye";
	}
}
