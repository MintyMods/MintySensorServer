package info.mintymods.mss.webapp.scheduling;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.mintymods.msm.MsmMonitorResponse;
import info.mintymods.msm.MsmSensor;
import info.mintymods.mss.webapp.services.SensorService;

@Service
public class MsmSchedulerService {

	private static final Logger log = LoggerFactory.getLogger(MsmSchedulerService.class);
	@Autowired
	private SensorService sensorService;

	public void processResponse(MsmMonitorResponse response) {
		final List<MsmSensor> sensors = response.getSensors();
		sensors.forEach((sensor) -> sensorService.addSensor(sensor));
		log.debug("Sensors:" + response.getSensors());
		// log.debug("Labels:" + response.getLabels());
		// log.debug("Readings:" + response.getReadings());
	}
}
