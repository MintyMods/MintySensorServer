package info.mintymods.repository.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

@Entity
@Table(name = "minty_sensor")
public class Sensor {

	// @GeneratedName(strategy = GenerationType.AUTO, generator = "minty_sensor_gen")
	// @SequenceGenerator(name = "minty_sensor_gen", sequenceName = "MINTY_SENSOR_SEQ")
	@Id
	@Column(name = "id", updatable = true, nullable = false)
	protected Long id;
	public static final String ICON = "fal fa-code-branch";
	@NotAudited
	private String name;
	@Audited
	private String desc;
	@Audited
	private int instance;

	public Sensor() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getInstance() {
		return instance;
	}

	public void setInstance(int instance) {
		this.instance = instance;
	}
}
