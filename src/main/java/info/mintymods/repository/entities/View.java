package info.mintymods.repository.entities;

public class View {

	private int id;
	private Label label;
	private boolean active;

	public View() { }

	public View(int id, Label label) {
		this.setId(id);
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
