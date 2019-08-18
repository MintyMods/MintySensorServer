package info.mintymods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import info.mintymods.mss.webapp.config.properties.MintyConfig;
import info.mintymods.repository.entities.enums.ProviderType;
import info.mintymods.utils.ssl.CertificateUtils;

@SpringBootApplication
@EnableJpaRepositories("info.mintymods.repository.dao")
@EntityScan("info.mintymods.repository.entities")
@ComponentScan(basePackages = {"info.mintymods.mss.webapp"})
@ServletComponentScan
@EnableConfigurationProperties(MintyConfig.class)
public class MintySensorServer extends SpringBootServletInitializer {

	private static final Logger log = LoggerFactory.getLogger(MintySensorServer.class);
	public static MintyConfig config;

	static void addFrameworkInitialisationHooks(final SpringApplication application) {
		log.info("Adding application init hooks listeners");
		application.addListeners((ApplicationListener<ApplicationEnvironmentPreparedEvent>) event -> {
			log.info("@JavaVersion#" + event.getEnvironment().getProperty("java.runtime.version"));
			try {
				CertificateUtils.createKeyStoreAndImportCertificate();
			} catch (final Exception e) {
				log.error(e.getMessage(), e);
				throw new RuntimeException(e.getMessage(), e);
			}
		});
	}

	public static void main(final String[] args) {
		config = SpringApplication.run(MintySensorServer.class, args).getBean(MintyConfig.class);
		log.info("Database URL:" + config.getDatabase().getUrl());
		log.info("Database Alias:" + config.getDatabase().getAlias());
	}

	// @Bean
	// public BasicErrorController basicErrorController() {
	// return new MintyErrorController(new MintyErrorAttributes(), new MintyErrorProperties());
	// }
	public static ProviderType getProviderType() {
		return ProviderType.HWINFO;
	}
	// @Bean
	// public SecurityWebFilterChain sseServerSpringSecurityFilterChain(ServerHttpSecurity http) {
	// http.authorizeExchange()
	// .anyExchange()
	// .permitAll();
	// return http.build();
	// }
}
