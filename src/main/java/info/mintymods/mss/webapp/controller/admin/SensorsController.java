package info.mintymods.mss.webapp.controller.admin;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SensorsController {

	@GetMapping({"/sensors/{sensor}"})
	public String sensor(Map<String, Object> model, @PathVariable("sensor") String sensor) {
		model.put("title", StringUtils.capitalize(sensor) + " Sensor");
		model.put("debug", "Minty");
		return "sensors/" + sensor;
	}
}
