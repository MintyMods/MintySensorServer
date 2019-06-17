package info.mintymods.mss.services.hwinfo;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestParam;

//@RestController
public class SensorController {

	private static final Logger log = LoggerFactory.getLogger(SensorController.class);
	private static final String template = "Request for Sensor %s!";
	private final AtomicLong counter = new AtomicLong();

	// @RequestMapping("/sensor")
	public Sensor sensor(@RequestParam(value = "name", defaultValue = "Core #0 Clock") String name) {
		log.info("Request received for sensor name " + name);
		return new Sensor(name, String.format(template, name));
	}
}