package info.mintymods.mss.webapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import info.mintymods.mss.webapp.config.properties.MintyConfig;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Autowired
	MintyConfig config;

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("info.mintymods.mss.webapp.controller.rest"))
				.paths(PathSelectors.any())
				.build();
		// .apiInfo(apiInfo());
	}
	// private ApiInfo apiInfo() {
	// return new ApiInfo(
	// config.getApplication().getName() + " REST API",
	// config.getApplication().getDescription(),
	// "API TOS",
	// "Terms of service",
	// new Contact(config.getApplication().getAuthor(), config.getApplication().getUrl(), config.getApplication().getEmail()),
	// "License of API", "API license URL", Collections.emptyList());
	// }
}
