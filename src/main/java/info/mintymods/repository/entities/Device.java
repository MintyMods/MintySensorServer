package info.mintymods.repository.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "minty_device")
public class Device extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "minty_device_gen")
	@SequenceGenerator(name = "minty_device_gen", sequenceName = "MINTY_DEVICE_SEQ")
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	// private Sensor[] sensors;
	// private Reading[] readings;
	public Device(Long id, Label label) {
		icon = "fal fa-memory";
		this.id = id;
		this.label = label;
	}
}
