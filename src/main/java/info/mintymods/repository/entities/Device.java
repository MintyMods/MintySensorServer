package info.mintymods.repository.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "minty_device")
public class Device extends BaseEntity {

	private final static String ICON = "fal fa-memory";
	private Sensor[] sensors;
	private Reading[] readings;

	public String getIcon() {
		return ICON;
	}
}
