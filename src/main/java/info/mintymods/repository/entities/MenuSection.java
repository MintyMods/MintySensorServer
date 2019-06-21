package info.mintymods.repository.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menu_sections")
public class MenuSection extends Audit {

	private final static String ICON = "fas fa-ellipsis-v";

	public static String getIcon() {
		return ICON;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private boolean active = true;
	private Label label;
	private String section;

	public MenuSection() {
	}

	public MenuSection(Label label, String section) {
		this.label = label;
		this.section = section;
	}

	public Long getId() {
		return id;
	}

	public Label getLabel() {
		return label;
	}

	public String getSection() {
		return section;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	public void setSection(String section) {
		this.section = section;
	}
}
