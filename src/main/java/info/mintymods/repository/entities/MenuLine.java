package info.mintymods.repository.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menu_lines")
public class MenuLine extends Audit {

	private final static String ICON = "fas fa-ellipsis-h";

	public static String getIcon() {
		return ICON;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private boolean active = true;
	private int parent_id;
	private Label label;
	private String url;

	public MenuLine() {
	}

	public MenuLine(int parent, Label label, String url) {
		parent_id = parent;
		this.label = label;
		this.url = url;
	}

	public Long getId() {
		return id;
	}

	public Label getLabel() {
		return label;
	}

	public int getParentId() {
		return parent_id;
	}

	public String getUrl() {
		return url;
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

	public void setParentId(int parent_id) {
		this.parent_id = parent_id;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
