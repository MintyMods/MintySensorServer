package info.mintymods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationListener;

@SpringBootApplication
public class MintySensorServer extends SpringBootServletInitializer {

	static void addFrameworkInitialisationHooks(SpringApplication application) {
		log.info("Adding application init hooks listeners");
		application.addListeners((ApplicationListener<ApplicationEnvironmentPreparedEvent>) event -> {
			String version = event.getEnvironment().getProperty("java.runtime.version");
			log.info("Running with Java {}", version);
			// try {
			// CertificateUtils.createKeyStoreAndImportCertificate();
			// } catch (Exception e) {
			// log.error(e.getMessage(), e);
			// throw new RuntimeException(e.getMessage(), e);
			// }
		});
	}

	private static final Logger log = LoggerFactory.getLogger(MintySensorServer.class);

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(MintySensorServer.class);
		application.run(args);
	}

}
