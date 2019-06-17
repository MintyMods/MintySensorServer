package info.mintymods.mss.webapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import info.mintymods.mss.webapp.controller.interceptors.SpringSecurityInterceptor;
import info.mintymods.mss.webapp.service.impl.AccountServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

	@Autowired
	private AccountServiceImpl accountServiceImpl;

	@Autowired
	private AuthenticationProvider authenticationProvider;

	@Autowired
	private AuthenticationSuccessHandler authenticationSuccessHandler;

	@Autowired
	private AuthenticationFailureHandler authenticationFailureHandler;

	@Autowired
	private SpringSecurityInterceptor springSecurityInterceptor;

	public SecurityConfig() {
		super();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.authenticationProvider(authenticationProvider)
				.userDetailsService(accountServiceImpl)
				.passwordEncoder(passwordEncoder());
	}

	@Override
	public void configure(WebSecurity webSecurity) throws Exception {
		webSecurity.ignoring()
				.antMatchers(
						"/css/**",
						"/font/**",
						"/**", // REMOPVE TJHOS
						"/images/**",
						"/js/**",
						"/vendors/**");
	}

	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
		// CONFIG : Use below code to disable csrf.
		/*
		 * httpSecurity.csrf()
		 * .disable()
		 * .authorizeRequests()
		 */

		httpSecurity.authorizeRequests()
				.antMatchers("/login/**").permitAll()
				.antMatchers("/login").permitAll()
				.antMatchers("/logout").permitAll()
				.antMatchers("/admin/signup").permitAll()
				.antMatchers("/error").permitAll()
				.antMatchers("/h2/**").permitAll()
				.antMatchers("/**").authenticated()
				.and()
				.formLogin()
				.loginPage("/login/form")
				.loginProcessingUrl("/login")
				.failureUrl("/login/form?error=true")
				.defaultSuccessUrl("/")
				.usernameParameter("id")
				.passwordParameter("password")
				.successHandler(authenticationSuccessHandler)
				.failureHandler(authenticationFailureHandler)
				.and()
				.headers()
				.frameOptions()
				.disable()
				.and()
				.csrf()
				.ignoringAntMatchers("/h2/**")
				.and()
				.logout()
				.deleteCookies("JSESSIONID")
				.clearAuthentication(true)
				.invalidateHttpSession(true)
				.logoutSuccessUrl("/")
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));

	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(springSecurityInterceptor);
	}

}
