package info.mintymods.repository.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Audited
@Entity
@Table(name = "minty_sensor")
public class Sensor extends BaseEntity {

	// @Id
	// @GeneratedValue(strategy = GenerationType.AUTO, generator = "minty_sensor_gen")
	// @SequenceGenerator(name = "minty_sensor_gen", sequenceName = "MINTY_SENSOR_SEQ")
	// @Column(name = "id", updatable = false, nullable = false)
	// private Long id;
	private int instance;

	public Sensor() {
	}

	public Sensor(Long id, int instance, Label label) {
		this.id = id;
		this.instance = instance;
		this.label = label;
		icon = "fal fa-code-branch";
	}

	public int getInstance() {
		return instance;
	}

	public void setInstance(int instance) {
		this.instance = instance;
	}
}
