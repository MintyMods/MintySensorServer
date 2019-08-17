package info.mintymods.repository.entities;

// @Audited
// @Entity
// @Table(name = "minty_menu_section")
public class MenuSection {

	public static final String ICON = "fal fa-ellipsis-v";
	// @Id
	// @GeneratedValue(strategy = GenerationType.AUTO, generator = "minty_menu_section_gen")
	// @SequenceGenerator(name = "minty_menu_section_gen", sequenceName = "MINTY_MENU_SECTION_SEQ")
	// @Column(name = "recordId", updatable = false, nullable = false)
	// private Long recordId;
	private String section;

	public MenuSection() {
	}

	public MenuSection(String section) {
		this.section = section;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}
}
