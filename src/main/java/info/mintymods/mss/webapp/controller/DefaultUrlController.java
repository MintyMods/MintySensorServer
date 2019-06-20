package info.mintymods.mss.webapp.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DefaultUrlController {

	@GetMapping({"/{page}"})
	public String processRequest(Map<String, Object> model, @PathVariable("page") String page) {
		model.put("page", page);
		model.put("title", "Debug : " + page);
		return "/" + page;
	}

}
