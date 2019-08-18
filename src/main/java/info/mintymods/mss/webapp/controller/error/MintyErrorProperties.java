package info.mintymods.mss.webapp.controller.error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.context.annotation.Configuration;

import info.mintymods.mss.webapp.config.properties.MintyConfig;

@Configuration
public class MintyErrorProperties extends ErrorProperties {

	@Autowired
	MintyConfig config;

	public MintyErrorProperties() {
		super();
	}
}
