package info.mintymods.mss.webapp.config;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

	private static final String STATIC_RESOURCE_LOCATIONS = "classpath:/static";

	// @Autowired
	// private AccountServiceImplTest accountServiceImpl;
	//
	// @Autowired
	// private AuthenticationProvider authenticationProvider;
	//
	// @Autowired
	// private AuthenticationSuccessHandler authenticationSuccessHandler;
	//
	// @Autowired
	// private AuthenticationFailureHandler authenticationFailureHandler;
	//
	// @Autowired
	// private SpringSecurityInterceptor springSecurityInterceptor;
	//
	// public SecurityConfig() {
	// super();
	// }
	//
	// @Bean
	// public PasswordEncoder passwordEncoder() {
	// return new BCryptPasswordEncoder();
	// }
	//
	// @Autowired
	// public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
	// authenticationManagerBuilder.authenticationProvider(authenticationProvider)
	// .userDetailsService(accountServiceImpl)
	// .passwordEncoder(passwordEncoder());
	// }
	//
	// @Override
	// public void configure(WebSecurity webSecurity) throws Exception {
	// webSecurity.ignoring()
	// .antMatchers(
	// "/css/**",
	// "/font/**",
	// "/**", // REMOVE THIS MAPPING = ALLOW ALL <-------------------------------------
	// "/images/**",
	// "/js/**",
	// "/vendors/**");
	// }
	//
	// @Override
	// public void configure(HttpSecurity httpSecurity) throws Exception {
	// // CONFIG : Use below code to disable csrf.
	// /*
	// * httpSecurity.csrf()
	// * .disable()
	// * .authorizeRequests()
	// */
	//
	// httpSecurity.authorizeRequests()
	// .antMatchers("/login/**").permitAll()
	// .antMatchers("/login").permitAll()
	// .antMatchers("/logout").permitAll()
	// .antMatchers("/admin/signup").permitAll()
	// .antMatchers("/error").permitAll()
	// .antMatchers("/h2/**").permitAll()
	// .antMatchers("/**").authenticated()
	// .and()
	// .formLogin()
	// .loginPage("/login/form")
	// .loginProcessingUrl("/login")
	// .failureUrl("/login/form?error=true")
	// .defaultSuccessUrl("/")
	// .usernameParameter("id")
	// .passwordParameter("password")
	// .successHandler(authenticationSuccessHandler)
	// .failureHandler(authenticationFailureHandler)
	// .and()
	// .headers()
	// .frameOptions()
	// .disable()
	// .and()
	// .csrf()
	// .ignoringAntMatchers("/h2/**")
	// .and()
	// .logout()
	// .deleteCookies("JSESSIONID")
	// .clearAuthentication(true)
	// .invalidateHttpSession(true)
	// .logoutSuccessUrl("/")
	// .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	//
	// }
	//
	// @Override
	// public void addInterceptors(InterceptorRegistry registry) {
	// registry.addInterceptor(springSecurityInterceptor);
	// }
	//
	// @Override
	// public void addResourceHandlers(ResourceHandlerRegistry registry) {
	// WebMvcConfigurer.super.addResourceHandlers(registry);
	// if (!registry.hasMappingForPattern("/webjars/**")) {
	// registry.addResourceHandler("/webjars/**").addResourceLocations(
	// "classpath:/META-INF/resources/webjars/");
	// }
	// if (!registry.hasMappingForPattern("/**")) {
	// registry.addResourceHandler("/**").addResourceLocations(STATIC_RESOURCE_LOCATIONS);
	// }
	// }

}
