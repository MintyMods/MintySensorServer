package info.mintymods.mss.webapp.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import info.mintymods.mss.webapp.services.ProviderService;
import info.mintymods.repository.entities.Provider;

@RestController
@RequestMapping("providers")
public class ProviderController {

	@Autowired
	private ProviderService providerService;

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteProviderById(@PathVariable Long id) {
		providerService.removeProviderById(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Provider> getAllProviders() {
		return providerService.getAllProviders();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Provider getProviderById(@PathVariable Long id) {
		return providerService.getProviderById(id);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertHost(@RequestBody Provider provider) {
		providerService.insertProvider(provider);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateHost(@RequestBody Provider provider) {
		providerService.updateProvider(provider);
	}
}
