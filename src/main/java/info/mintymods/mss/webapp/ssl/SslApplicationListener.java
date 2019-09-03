package info.mintymods.mss.webapp.ssl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;

public class SslApplicationListener implements ApplicationListener<ApplicationPreparedEvent> {

	private static final Logger log = LoggerFactory.getLogger(SslApplicationListener.class);

	@Override
	public void onApplicationEvent(final ApplicationPreparedEvent event) {
		log.info("Adding application init hook for SSL/HTTPS support");
		try {
			CertificateStoreUtils.createKeyStoreAndImportCertificate();
		} catch (final Exception e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		}
	}
}
