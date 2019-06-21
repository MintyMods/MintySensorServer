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

	@Override
	public boolean equals(Object obj) {
		if (this == obj) { return true; }
		if (obj == null) { return false; }
		if (getClass() != obj.getClass()) { return false; }
		final Provider other = (Provider) obj;
		if (active != other.active) { return false; }
		if (id == null) {
			if (other.id != null) { return false; }
		} else
			if (!id.equals(other.id)) { return false; }
		if (label == null) {
			if (other.label != null) { return false; }
		} else
			if (!label.equals(other.label)) { return false; }
		if (type != other.type) { return false; }
		return true;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + (active ? 1231 : 1237);
		result = (prime * result) + ((id == null) ? 0 : id.hashCode());
		result = (prime * result) + ((label == null) ? 0 : label.hashCode());
		result = (prime * result) + ((type == null) ? 0 : type.hashCode());
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

	public void setType(ProviderType type) {
		this.type = type;
	}
}
