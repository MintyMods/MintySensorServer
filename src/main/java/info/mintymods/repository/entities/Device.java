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
	public Device(Long recordId, Label label) {
		this.setRecordId(recordId);
		icon = "fal fa-memory";
		this.setRecordId(recordId);
		this.label = label;
	}
}
