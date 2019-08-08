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
import java.util.Optional;

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

	public void addSensor(Sensor sensor) {
		sensors.put(sensor.getId(), sensor);
	}

	public Collection<Sensor> getAllSensors() {
		return sensors.values();
	}

	public Sensor getSensorById(Long id) {
		return sensors.get(id);
	}

	public void removeSensorById(Long id) {
		sensors.remove(id);
	}

	public void updateSensor(Sensor newSensor) {
		final Sensor oldSensor = sensors.get(newSensor.getId());
		oldSensor.setLabel(newSensor.getLabel());
		sensors.put(newSensor.getId(), oldSensor);
	}

	@Override
	public <S extends Sensor> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Sensor> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Sensor> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Sensor> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Sensor> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(Sensor entity) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteAll(Iterable<? extends Sensor> entities) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
	}
}
