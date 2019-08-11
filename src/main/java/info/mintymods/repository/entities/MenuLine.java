package info.mintymods.repository.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Audited
@Entity
@Table(name = "minty_menu_line")
public class MenuLine extends BaseEntity {

	private static final String ICON = "fal fa-ellipsis-h";
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "minty_menu_line_gen")
	@SequenceGenerator(name = "minty_menu_line_gen", sequenceName = "MINTY_MENU_LINE_SEQ")
	@Column(name = "recordId", updatable = false, nullable = false)
	private Long recordId;
	@OneToOne(cascade = {CascadeType.ALL})
	private MenuSection section;
	private String url;

	public MenuLine() {
	}

	public MenuLine(MenuSection parent, Label label, String url) {
		setMenuSection(parent);
		setLabel(label);
		setUrl(url);
		setIcon(ICON);
	}

	public MenuSection getParentId() {
		return section;
	}

	public String getUrl() {
		return url;
	}

	public void setMenuSection(MenuSection section) {
		this.section = section;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
