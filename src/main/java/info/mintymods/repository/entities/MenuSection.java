package info.mintymods.repository.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "minty_menu_section")
public class MenuSection extends BaseEntity {

	private final static String ICON = "fal fa-ellipsis-v";
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String section;

	public MenuSection() {
	}

	public MenuSection(Label label, String section) {
		this.label = label;
		this.section = section;
	}

	public String getIcon() {
		return ICON;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public Label getLabel() {
		return label;
	}

	public String getSection() {
		return section;
	}

	@Override
	public boolean isActive() {
		return active;
	}

	@Override
	public void setActive(boolean active) {
		this.active = active;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public void setLabel(Label label) {
		this.label = label;
	}

	public void setSection(String section) {
		this.section = section;
	}
}
