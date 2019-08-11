package info.mintymods.mss.webapp.controller.rest;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

	// https://github.com/eugenp/tutorials/blob/master/spring-boot-crud/src/main/java/com/baeldung/crud/controllers/UserController.java
	@Autowired
	private final ViewService viewService;

	@Autowired
	public ViewController(ViewService viewService) {
		this.viewService = viewService;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteViewById(@PathVariable Long id) {
		viewService.deleteView(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public Collection<View> getAllViews() {
		return viewService.getAllViews();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<View> getViewById(@PathVariable Long id) {
		return viewService.getView(id);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> insertView(@RequestBody View view) {
		viewService.addView(view);
		return new ResponseEntity<String>("View " + view.getRecordId() + " added", HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateView(@RequestBody View view) {
		viewService.updateView(view);
		return new ResponseEntity<String>("View " + view.getRecordId() + " updated", HttpStatus.OK);
	}
}
