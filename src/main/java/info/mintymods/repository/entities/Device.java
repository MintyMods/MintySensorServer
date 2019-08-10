package info.mintymods.repository.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Audited
@Entity
@Table(name = "minty_device")
public class Device extends BaseEntity {

	// private Sensor[] sensors;
	// private Reading[] readings;
	public Device(Long id, Label label) {
		icon = "fal fa-memory";
		this.id = id;
		this.label = label;
	}
}
