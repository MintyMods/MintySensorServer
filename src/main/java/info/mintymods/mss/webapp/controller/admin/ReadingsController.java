package info.mintymods.mss.webapp.controller.admin;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ReadingsController {

	@GetMapping({"/readings/{reading}"})
	public String reading(Map<String, Object> model, @PathVariable("reading") String reading) {
		model.put("reading", reading);
		model.put("title", "Reading : " + reading);
		return "readings/" + reading;
	}
}
