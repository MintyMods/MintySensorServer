package info.mintymods.mss.webapp.config;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.github.jknack.handlebars.springmvc.HandlebarsViewResolver;

import info.mintymods.mss.webapp.handlebars.SpringSecurityAuthorizeHelper;

@Configuration
public class WebApplicationConfig {

	@Autowired
	private HandlebarsViewResolver handlebarsViewResolver;

	@Autowired
	private SpringSecurityAuthorizeHelper springSecurityAuthorizeHelper;

	@PostConstruct
	public void registerHelper() {
		handlebarsViewResolver.registerHelper(SpringSecurityAuthorizeHelper.NAME, springSecurityAuthorizeHelper);
	}

	@Bean
	public RestTemplate getRestTemplate() { return new RestTemplate(); }

	@Bean
	public ModelMapper getModelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;
	}
}
