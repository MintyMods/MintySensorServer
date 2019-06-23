package info.mintymods.repository.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menu_lines")
public class MenuLine {

	private final static String ICON = "fal fa-ellipsis-h";

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

	@Override
	public boolean equals(Object obj) {
		if (this == obj) { return true; }
		if (obj == null) { return false; }
		if (getClass() != obj.getClass()) { return false; }
		final MenuLine other = (MenuLine) obj;
		if (active != other.active) { return false; }
		if (id == null) {
			if (other.id != null) { return false; }
		} else
			if (!id.equals(other.id)) { return false; }
		if (label == null) {
			if (other.label != null) { return false; }
		} else
			if (!label.equals(other.label)) { return false; }
		if (parent_id != other.parent_id) { return false; }
		if (url == null) {
			if (other.url != null) { return false; }
		} else
			if (!url.equals(other.url)) { return false; }
		return true;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + (active ? 1231 : 1237);
		result = (prime * result) + ((id == null) ? 0 : id.hashCode());
		result = (prime * result) + ((label == null) ? 0 : label.hashCode());
		result = (prime * result) + parent_id;
		result = (prime * result) + ((url == null) ? 0 : url.hashCode());
		return result;
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
