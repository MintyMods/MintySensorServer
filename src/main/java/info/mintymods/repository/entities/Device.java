package info.mintymods.repository.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Audited
@Entity
@Table(name = "minty_device")
public class Device { // extends Auditable<String>

	public static final String ICON = "fal fa-memory";
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "minty_device_gen")
	@SequenceGenerator(name = "minty_device_gen", sequenceName = "MINTY_DEVICE_SEQ")
	@Column(name = "id", updatable = false, nullable = false)
	private final Long id;

	// private Sensor[] sensors;
	// private Reading[] readings;
	public Device(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
}
