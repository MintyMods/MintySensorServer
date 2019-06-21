package info.mintymods.repository.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import info.mintymods.repository.entities.enums.ProviderType;

public class Provider extends Audit {

	private final static String ICON = "fab fa-cloudscale";

	public static String getIcon() {
		return ICON;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private boolean active = true;
	private ProviderType type;
	private Label label;

	public Provider() {
	}

	public Provider(Long id, ProviderType type, Label label) {
		this.id = id;
		this.type = type;
		this.label = label;
	}

	public Long getId() {
		return id;
	}

	public Label getLabel() {
		return label;
	}

	public ProviderType getType() {
		return type;
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

	public void setType(ProviderType type) {
		this.type = type;
	}
}
