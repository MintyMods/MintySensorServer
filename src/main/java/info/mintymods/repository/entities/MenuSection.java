package info.mintymods.repository.entities;

public class MenuSection {

	private Label label;
	private String section;
	private boolean active;

	public MenuSection() { }

	public MenuSection(Label label, String section, boolean active) {
		this.label = label;
		this.section = section;
		this.active = active;
	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
