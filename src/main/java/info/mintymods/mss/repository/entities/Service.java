package info.mintymods.mss.repository.entities;

public class Service {

	private Label label;
	private boolean active;

	public Service() {
		this.active = true;
	}

	public Service(Label label) {
		this.label = label;
		this.active = true;
	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
