package info.mintymods.mss.webapp.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import info.mintymods.mss.webapp.services.ViewService;
import info.mintymods.repository.entities.View;

@RestController
@RequestMapping("views")
public class ViewController {

	@Autowired
	private ViewService viewService;

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteViewById(@PathVariable Long id) {
		viewService.removeViewById(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public Collection<View> getAllViews() {
		return viewService.getAllViews();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public View getViewById(@PathVariable Long id) {
		return viewService.getViewById(id);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertView(@RequestBody View view) {
		viewService.insertView(view);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateView(@RequestBody View view) {
		viewService.updateView(view);
	}
}
