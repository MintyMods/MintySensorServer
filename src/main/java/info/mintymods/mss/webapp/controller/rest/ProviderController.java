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

import info.mintymods.mss.webapp.services.ProviderService;
import info.mintymods.repository.entities.Provider;

@RestController
@RequestMapping("providers")
public class ProviderController {

	@Autowired
	private ProviderService providerService;

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteProviderById(@PathVariable Long id) {
		providerService.deleteProvider(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Provider> getAllProviders() {
		return providerService.getAllProviders();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Provider> getProviderById(@PathVariable Long id) {
		return providerService.getProvider(id);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> insertHost(@RequestBody Provider provider) {
		providerService.addProvider(provider);
		return new ResponseEntity<String>("Provider " + provider.getId() + " added", HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateHost(@RequestBody Provider provider) {
		providerService.updateProvider(provider);
		return new ResponseEntity<String>("Provider " + provider.getId() + " updated", HttpStatus.OK);
	}
}
