package info.mintymods.repository.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "minty_view")
public class View extends BaseEntity {

	private final static String ICON = "fal fa-eye";
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public View() {
	}

	public View(Long id, Label label) {
		this.id = id;
		this.label = label;
	}

	public String getIcon() {
		return ICON;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "View{" + "id=" + id + ", active=" + active + ", label=" + label + '}';
	}
}
