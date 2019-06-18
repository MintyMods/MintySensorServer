package info.mintymods.mss.webapp.tomcat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Configuration;

import info.mintymods.utils.ssl.CertificateUtils;

@Configuration
public class TomcatConfiguration implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {

	private static final Logger log = LoggerFactory.getLogger(TomcatConfiguration.class);

	@Override
	public void customize(TomcatServletWebServerFactory factory) {

		try {
			CertificateUtils.createKeyStoreAndImportCertificate();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		}

		factory.addContextLifecycleListeners(new TomcatLifeCycleListener());
	}

}