package info.mintymods.repository.entities;

import info.mintymods.repository.entities.enums.ProviderType;

public class Provider {

	private int id;
	private ProviderType type;
	private Label label;
	private boolean active;

	public Provider() { }

	public Provider(int id, ProviderType type, Label label) {
		this.id = id;
		this.type = type;
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
