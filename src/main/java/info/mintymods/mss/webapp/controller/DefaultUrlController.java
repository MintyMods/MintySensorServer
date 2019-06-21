package info.mintymods.mss.webapp.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DefaultUrlController {

	@GetMapping({"/pages/{id}"})
	public String processRequest(Map<String, Object> model, @PathVariable("id") String id) {
		model.put("page", id);
		model.put("title", "Debug : " + id);
		return "/" + id;
	}

}
