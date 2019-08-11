package info.mintymods.repository.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import info.mintymods.msm.MsmSensor;

@Audited
@Entity
@Table(name = "minty_sensor")
public class Sensor extends BaseEntity {

	private static final String ICON = "fal fa-code-branch";
	private int instance;
	private String name;

	public Sensor() {
	}

	public Sensor(Long recordId, int instance, Label label) {
		setInstance(instance);
		setRecordId(recordId);
		setLabel(label);
		setIcon(ICON);
	}

	public Sensor(MsmSensor sensor) {
		setInstance(sensor.getInstance());
		setId(sensor.getId());
		setName(sensor.getName());
		setLabel(sensor.getLabel());
	}

	public int getInstance() {
		return instance;
	}

	public void setInstance(int instance) {
		this.instance = instance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
