package info.mintymods.mss.repository.dao;

import static info.mintymods.msm.MsmSensorType.CLOCK;
import static info.mintymods.msm.MsmSensorType.CURRENT;
import static info.mintymods.msm.MsmSensorType.FAN;
import static info.mintymods.msm.MsmSensorType.NONE;
import static info.mintymods.msm.MsmSensorType.OTHER;
import static info.mintymods.msm.MsmSensorType.POWER;
import static info.mintymods.msm.MsmSensorType.TEMP;
import static info.mintymods.msm.MsmSensorType.USAGE;
import static info.mintymods.msm.MsmSensorType.VOLT;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import info.mintymods.mss.repository.entities.Label;
import info.mintymods.mss.repository.entities.Sensor;

@Repository
public class SensorDoa {

	private static Map<Integer, Sensor> sensors;

	static {
		sensors = new HashMap<Integer, Sensor>() {

			private static final long serialVersionUID = 5209229027622341474L;
			{
				put(0, new Sensor(0, 0, new Label(NONE)));
				put(1, new Sensor(1, 0, new Label(CLOCK)));
				put(2, new Sensor(2, 0, new Label(CURRENT)));
				put(3, new Sensor(3, 0, new Label(FAN)));
				put(4, new Sensor(4, 0, new Label(OTHER)));
				put(5, new Sensor(5, 0, new Label(POWER)));
				put(6, new Sensor(6, 0, new Label(TEMP)));
				put(7, new Sensor(7, 0, new Label(USAGE)));
				put(8, new Sensor(8, 0, new Label(VOLT)));
			}
		};
	}

	public Collection<Sensor> getAllSensors() {
		return sensors.values();
	}

}
