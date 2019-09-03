package info.mintymods.mss.webapp.ssl.tomcat;

import java.security.KeyStore;

import org.springframework.boot.web.server.Ssl;
import org.springframework.boot.web.server.SslStoreProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import info.mintymods.mss.webapp.ssl.SslConfig;

@Component
public class ConfigureSsl {

	@Bean
	public Ssl getSsl() {
		final Ssl ssl = new Ssl();
		ssl.setKeyAlias(SslConfig.getKeyAlias());
		// ssl.setKeyPassword(SslConfig.getKeyPassword());
		ssl.setKeyStoreProvider(SslConfig.getKeyStoreProvider());
		ssl.setKeyStorePassword(SslConfig.getKeyPassword());
		ssl.setKeyStore(SslConfig.getKeyStore());
		ssl.setKeyStoreType(SslConfig.getKeyStoreType());
		return ssl;
	}

	@Bean
	public SslStoreProvider getProvider() {
		final SslStoreProvider provider = new SslStoreProvider() {

			@Override
			public KeyStore getTrustStore() throws Exception {
				return null;
			}

			@Override
			public KeyStore getKeyStore() throws Exception {
				return null;
			}
		};
		return provider;
	}
}
