package info.mintymods.mss.webapp.config;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class SiteConfig implements WebMvcConfigurer {

	private static final String STATIC_RESOURCE_LOCATIONS = "/static";

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		if (!registry.hasMappingForPattern("/public/webjars/**")) {
			registry.addResourceHandler("/public/webjars/**").addResourceLocations(
					"classpath:/META-INF/resources/webjars/");
		}
		if (!registry.hasMappingForPattern("/**")) {
			registry.addResourceHandler("/**").addResourceLocations(STATIC_RESOURCE_LOCATIONS);
		}
	}
}
