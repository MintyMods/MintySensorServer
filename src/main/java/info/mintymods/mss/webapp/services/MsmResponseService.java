package info.mintymods.mss.webapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.mintymods.msm.MsmMonitorResponse;
import info.mintymods.msm.MsmSensor;
import info.mintymods.msm.MsmSensorReading;

@Service
public class MsmResponseService {

	@Autowired
	private SensorService sensorService;

	public void processResponse(MsmMonitorResponse response) {
		final List<String> labels = response.getLabels();
		labels.forEach((label) -> System.out.println(label));
		final List<MsmSensorReading> readings = response.getReadings();
		readings.forEach((reading) -> System.out.println(reading));
		final List<MsmSensor> sensors = response.getSensors();
		sensors.forEach((sensor) -> System.out.println(sensor));
	}
}
