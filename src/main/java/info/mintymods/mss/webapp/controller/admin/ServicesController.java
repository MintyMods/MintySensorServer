package info.mintymods.mss.webapp.controller.admin;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ServicesController {

	@GetMapping({"/services/{service}"})
	public String service(Map<String, Object> model, @PathVariable("service") String service) {
		model.put("service", service);
		model.put("title", "Service : " + service);
		return "services/" + service;
	}
}
