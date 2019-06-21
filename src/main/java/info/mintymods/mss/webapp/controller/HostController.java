package info.mintymods.mss.webapp.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteHostById(@PathVariable Long id) {
		hostService.removeHostById(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Host> getAllHosts() {
		return hostService.getAllHosts();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Host getHostById(@PathVariable Long id) {
		return hostService.getHostById(id);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertHost(@RequestBody Host host) {
		hostService.insertHost(host);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateHost(@RequestBody Host host) {
		hostService.updateHost(host);
	}
}
