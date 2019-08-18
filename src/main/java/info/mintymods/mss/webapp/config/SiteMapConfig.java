package info.mintymods.mss.webapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.EncodedResourceResolver;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
@EnableWebMvc
public class SiteMapConfig implements WebMvcConfigurer {

	private static final String STATIC_RESOURCE_LOCATIONS = "classpath:/static/";

	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		// if (!registry.hasMappingForPattern("/public/webjars/**")) {
		// registry.addResourceHandler("/public/webjars/**").addResourceLocations(
		// "classpath:/META-INF/resources/webjars/");
		// }
		registry
				.addResourceHandler("/**")
				.addResourceLocations(STATIC_RESOURCE_LOCATIONS)
				.setCachePeriod(3600)
				.resourceChain(true)
				.addResolver(new EncodedResourceResolver())
				.addResolver(new PathResourceResolver());
		// registry.addResourceHandler("/img/**").addResourceLocations("classpath:/static/img/");
		// registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
		// registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/webjars/");
		// registry
		// .addResourceHandler("/js/**")
		// .addResourceLocations("classpath:/static/js/")
		// .setCachePeriod(3600)
		// .resourceChain(true)
		// .addResolver(new PathResourceResolver());
		// registry
		// .addResourceHandler("/resources/**")
		// .addResourceLocations("/resources/", "/other-resources/")
		// .setCachePeriod(3600)
		// .resourceChain(true)
		// .addResolver(new PathResourceResolver());
		// registry
		// .addResourceHandler("/other-files/**")
		// .addResourceLocations("file:/Users/Me/")
		// .setCachePeriod(3600)
		// .resourceChain(true)
		// .addResolver(new EncodedResourceResolver());
		// registry.addResourceHandler("/public/**")
		// .addResourceLocations(PUBLIC_RESOURCE_LOCATIONS);
		// registry.addResourceHandler("/static/**")
		// .addResourceLocations(STATIC_RESOURCE_LOCATIONS);
	}
}
