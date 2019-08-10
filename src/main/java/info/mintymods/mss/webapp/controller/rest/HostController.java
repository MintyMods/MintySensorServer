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

import info.mintymods.mss.webapp.services.HostService;
import info.mintymods.repository.entities.Host;

@RestController
@RequestMapping("hosts")
public class HostController {

	@Autowired
	private HostService hostService;

	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public void deleteHostById(@PathVariable String id) {
		hostService.deleteHost(Long.valueOf(id));
	}

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Host> getAllHosts() {
		return hostService.getAllHosts();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Host> getHostById(@PathVariable String id) {
		return hostService.getHost(Long.valueOf(id));
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> insertHost(@RequestBody Host host) {
		hostService.addHost(host);
		return new ResponseEntity<String>("Host " + host.getId() + " added", HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateHost(@RequestBody Host host) {
		hostService.updateHost(host);
		return new ResponseEntity<String>("Host " + host.getId() + " updated", HttpStatus.OK);
	}
}
