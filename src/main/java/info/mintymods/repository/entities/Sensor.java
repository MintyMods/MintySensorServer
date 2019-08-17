package info.mintymods.repository.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "minty_sensor")
public class Sensor {

	// @GeneratedName(strategy = GenerationType.AUTO, generator = "minty_sensor_gen")
	// @SequenceGenerator(name = "minty_sensor_gen", sequenceName = "MINTY_SENSOR_SEQ")
	@Id
	@Column(name = "id", updatable = true, nullable = false)
	protected Long id;
	public static final String ICON = "fal fa-code-branch";
	private String name;
	private String desc;
	private int instance;

	public Sensor() {
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(final String desc) {
		this.desc = desc;
	}

	public int getInstance() {
		return instance;
	}

	public void setInstance(final int instance) {
		this.instance = instance;
	}
}
