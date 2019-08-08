package info.mintymods.repository.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "minty_menu_line")
public class MenuLine extends BaseEntity {

	private final static String ICON = "fal fa-ellipsis-h";
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int parentId;
	private String url;

	public MenuLine() {
	}

	public MenuLine(int parent, Label label, String url) {
		parentId = parent;
		this.label = label;
		this.url = url;
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

	public int getParentId() {
		return parentId;
	}

	public String getUrl() {
		return url;
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

	public void setParentId(int parent_id) {
		parentId = parent_id;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
