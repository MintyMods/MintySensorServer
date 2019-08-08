package info.mintymods.repository.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "minty_sensor")
public class Sensor extends BaseEntity {

	private final static String ICON = "fal fa-code-branch";
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int instance;

	public Sensor() {
	}

	public Sensor(Long id, int instance, Label label) {
		this.id = id;
		this.instance = instance;
		this.label = label;
	}

	public String getIcon() {
		return ICON;
	}

	@Override
	public Long getId() {
		return id;
	}

	public int getInstance() {
		return instance;
	}

	@Override
	public Label getLabel() {
		return label;
	}

	@Override
	public boolean isActive() {
		return active;
	}

	@Override
	public void setActive(boolean active) {
		this.active = active;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setInstance(int instance) {
		this.instance = instance;
	}

	@Override
	public void setLabel(Label label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "Sensor{" + "id=" + id + ", instance=" + instance + ", label=" + label + '}';
	}
}
