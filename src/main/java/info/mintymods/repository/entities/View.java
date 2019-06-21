package info.mintymods.repository.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class View extends Audit {

	private final static String ICON = "far fa-eye";

	public static String getIcon() {
		return ICON;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private boolean active = true;
	private Label label;

	public View() {
	}

	public View(Long id, Label label) {
		this.id = id;
		this.label = label;
	}

	public Long getId() {
		return id;
	}

	public Label getLabel() {
		return label;
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
}
