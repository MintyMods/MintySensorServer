package info.mintymods.repository.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Audited
@Entity
@Table(name = "minty_view")
public class View extends BaseEntity {

	final static String ICON = "fal fa-eye";

	public View() {
	}

	public View(Long recordId, Label label) {
		this.recordId = recordId;
		this.label = label;
		// icon =
	}
}
