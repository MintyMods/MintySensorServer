package info.mintymods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import info.mintymods.utils.ssl.CertificateUtils;

@SpringBootApplication
@EnableJpaRepositories("info.mintymods.repository.dao")
@EntityScan("info.mintymods.repository.entities")
@ComponentScan(basePackages = {"info.mintymods.mss.webapp"})
// @EnableJpaRepositories
// @EnableScheduling
// @Import({MsmSchedulerConfig.class})
public class MintySensorServer extends SpringBootServletInitializer {

	private static final Logger log = LoggerFactory.getLogger(MintySensorServer.class);

	static void addFrameworkInitialisationHooks(SpringApplication application) {
		log.info("Adding application init hooks listeners");
		application.addListeners((ApplicationListener<ApplicationEnvironmentPreparedEvent>) event -> {
			final String version = event.getEnvironment().getProperty("java.runtime.version");
			log.info("Running with Java {}", version);
			try {
				CertificateUtils.createKeyStoreAndImportCertificate();
			} catch (final Exception e) {
				log.error(e.getMessage(), e);
				throw new RuntimeException(e.getMessage(), e);
			}
		});
	}

	public static void main(String[] args) {
		final SpringApplication application = new SpringApplication(MintySensorServer.class);
		application.run(args);
	}
}
