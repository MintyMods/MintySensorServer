package info.mintymods;

//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.EncodedResourceResolver;
import org.springframework.web.servlet.resource.PathResourceResolver;

public class SiteConfig implements WebMvcConfigurer {

	private static final String STATIC_RESOURCE_LOCATIONS = "/static";

	// @Override
	// public void addResourceHandlers(ResourceHandlerRegistry registry) {
	// WebMvcConfigurer.super.addResourceHandlers(registry);
	// if (!registry.hasMappingForPattern("/public/webjars/**")) {
	// registry.addResourceHandler("/public/webjars/**").addResourceLocations(
	// "classpath:/META-INF/resources/webjars/");
	// }
	// if (!registry.hasMappingForPattern("/**")) {
	// registry.addResourceHandler("/**").addResourceLocations(STATIC_RESOURCE_LOCATIONS);
	// }
	// }

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/imgages/**").addResourceLocations("/imgages/");
		registry.addResourceHandler("/css/**").addResourceLocations("/css/");
		registry.addResourceHandler("/html/**").addResourceLocations("/html/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/webjars/");

		registry
				.addResourceHandler("/js/**")
				.addResourceLocations("/js/")
				.setCachePeriod(3600)
				.resourceChain(true)
				.addResolver(new PathResourceResolver());

		registry
				.addResourceHandler("/resources/**")
				.addResourceLocations("/resources/", "/other-resources/")
				.setCachePeriod(3600)
				.resourceChain(true)
				.addResolver(new PathResourceResolver());

		registry
				.addResourceHandler("/other-files/**")
				.addResourceLocations("file:/Users/Me/")
				.setCachePeriod(3600)
				.resourceChain(true)
				.addResolver(new EncodedResourceResolver());
	}

}
