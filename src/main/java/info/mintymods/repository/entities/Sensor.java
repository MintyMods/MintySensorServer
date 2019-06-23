package info.mintymods.repository.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Sensor {

	private final static String ICON = "fal fa-code-branch";

	public static String getIcon() {
		return ICON;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private boolean active = true;
	private int instance;
	private Label label;

	public Sensor() {
	}

	public Sensor(Long id, int instance, Label label) {
		this.id = id;
		this.instance = instance;
		this.label = label;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) { return true; }
		if (obj == null) { return false; }
		if (getClass() != obj.getClass()) { return false; }
		final Sensor other = (Sensor) obj;
		if (active != other.active) { return false; }
		if (id == null) {
			if (other.id != null) { return false; }
		} else
			if (!id.equals(other.id)) { return false; }
		if (instance != other.instance) { return false; }
		if (label == null) {
			if (other.label != null) { return false; }
		} else
			if (!label.equals(other.label)) { return false; }
		return true;
	}

	public Long getId() {
		return id;
	}

	public int getInstance() {
		return instance;
	}

	public Label getLabel() {
		return label;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + (active ? 1231 : 1237);
		result = (prime * result) + ((id == null) ? 0 : id.hashCode());
		result = (prime * result) + instance;
		result = (prime * result) + ((label == null) ? 0 : label.hashCode());
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

	public void setInstance(int instance) {
		this.instance = instance;
	}

	public void setLabel(Label label) {
		this.label = label;
	}
}
