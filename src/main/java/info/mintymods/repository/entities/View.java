package info.mintymods.repository.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Audited
@Entity
@Table(name = "minty_view")
public class View extends BaseEntity {

	public View() {
	}

	public View(Long id, Label label) {
		this.id = id;
		this.label = label;
		icon = "fal fa-eye";
	}
}
