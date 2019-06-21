package info.mintymods.repository.entities;

public class Device {

	private final static String ICON = "fas fa-memory";

	public static String getIcon() {
		return ICON;
	}

	private Sensor[] sensors;
	private Reading[] readings;
}
