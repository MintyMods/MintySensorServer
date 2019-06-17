package info.mintymods.mss.webapp.controller.admin;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class NavigationController {

	@GetMapping({"/nav/{page}"})
	public String nav(Map<String, Object> model, @PathVariable("page") String page) {
		model.put("page", page);
		model.put("title", "Navigation : " + page);
		model.put("nav", "Minty");

		return "nav/" + page;
	}
}
