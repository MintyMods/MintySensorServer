package info.mintymods.repository.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Sensor extends Audit {

	private final static String ICON = "fas fa-code-branch";

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

	public Long getId() {
		return id;
	}

	public int getInstance() {
		return instance;
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

	public void setInstance(int instance) {
		this.instance = instance;
	}

	public void setLabel(Label label) {
		this.label = label;
	}
}
