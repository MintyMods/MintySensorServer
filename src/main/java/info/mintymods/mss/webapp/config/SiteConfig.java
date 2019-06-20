package info.mintymods.mss.webapp.config;

//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class SiteConfig implements WebMvcConfigurer {
	// public class SiteConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

	private static final String STATIC_RESOURCE_LOCATIONS = "/static";

	// @Override
	// protected void configure(HttpSecurity http) throws Exception {
	// http.authorizeRequests().anyRequest().authenticated()
	// .and().httpBasic();
	// }

	// @Bean
	// public PasswordEncoder passwordEncoder() {
	// return new BCryptPasswordEncoder();
	// }

	// @Override
	// public void configure(WebSecurity webSecurity) throws Exception {
	// webSecurity.ignoring().antMatchers("/public/**");
	// }

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
