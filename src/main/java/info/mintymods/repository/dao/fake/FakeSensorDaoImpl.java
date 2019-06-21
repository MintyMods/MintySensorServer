package info.mintymods.repository.dao.fake;

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

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import info.mintymods.repository.dao.SensorDoa;
import info.mintymods.repository.entities.Label;
import info.mintymods.repository.entities.Sensor;

@Repository
@Qualifier("fakeData")
public class FakeSensorDaoImpl implements SensorDoa {

	private static Map<Long, Sensor> sensors;
	static {
		sensors = new HashMap<Long, Sensor>() {

			private static final long serialVersionUID = 5209229027622341474L;
			{
				put(0l, new Sensor(0l, 0, new Label(NONE)));
				put(1l, new Sensor(1l, 0, new Label(CLOCK)));
				put(2l, new Sensor(2l, 0, new Label(CURRENT)));
				put(3l, new Sensor(3l, 0, new Label(FAN)));
				put(4l, new Sensor(4l, 0, new Label(OTHER)));
				put(5l, new Sensor(5l, 0, new Label(POWER)));
				put(6l, new Sensor(6l, 0, new Label(TEMP)));
				put(7l, new Sensor(7l, 0, new Label(USAGE)));
				put(8l, new Sensor(8l, 0, new Label(VOLT)));
			}
		};
	}

	@Override
	public void addSensor(Sensor sensor) {
		sensors.put(sensor.getId(), sensor);
	}

	@Override
	public Collection<Sensor> getAllSensors() {
		return sensors.values();
	}

	@Override
	public Sensor getSensorById(Long id) {
		return sensors.get(id);
	}

	@Override
	public void removeSensorById(Long id) {
		sensors.remove(id);
	}

	@Override
	public void updateSensor(Sensor newSensor) {
		final Sensor oldSensor = sensors.get(newSensor.getId());
		oldSensor.setLabel(newSensor.getLabel());
		sensors.put(newSensor.getId(), oldSensor);
	}
}
