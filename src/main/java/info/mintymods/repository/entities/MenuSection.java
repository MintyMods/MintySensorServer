package info.mintymods.repository.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Audited
@Entity
@Table(name = "minty_menu_section")
public class MenuSection extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "minty_menu_section_gen")
	@SequenceGenerator(name = "minty_menu_section_gen", sequenceName = "MINTY_MENU_SECTION_SEQ")
	@Column(name = "recordId", updatable = false, nullable = false)
	private Long recordId;
	private String section;

	public MenuSection() {
	}

	public MenuSection(Label label, String section) {
		this.label = label;
		this.section = section;
		icon = "fal fa-ellipsis-v";
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}
}
