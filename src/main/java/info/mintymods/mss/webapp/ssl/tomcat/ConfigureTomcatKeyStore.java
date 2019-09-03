package info.mintymods.mss.webapp.ssl.tomcat;

import java.io.FileNotFoundException;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.webresources.TomcatURLStreamHandlerFactory;
import org.apache.coyote.ProtocolHandler;
import org.apache.coyote.http11.AbstractHttp11JsseProtocol;
import org.apache.tomcat.util.net.SSLHostConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.Ssl;
import org.springframework.boot.web.server.SslStoreProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

@Configuration
@Component
public class ConfigureTomcatKeyStore {

	private static final Logger log = LoggerFactory.getLogger(ConfigureTomcatKeyStore.class);
	@Autowired
	private final Ssl ssl;
	@Autowired
	private final SslStoreProvider provider;

	public ConfigureTomcatKeyStore(final Ssl ssl, final SslStoreProvider provider) {
		this.ssl = ssl;
		this.provider = provider;
	}

	public void customize(final Connector connector) {
		final ProtocolHandler handler = connector.getProtocolHandler();
		configureSsl((AbstractHttp11JsseProtocol<?>) handler, ssl, provider);
		connector.setScheme("https");
		connector.setSecure(true);
	}

	protected void configureSsl(final AbstractHttp11JsseProtocol<?> protocol, final Ssl ssl, final SslStoreProvider provider) {
		protocol.setSSLEnabled(true);
		protocol.setSslProtocol(ssl.getProtocol());
		configureSslClientAuth(protocol, ssl);
		protocol.setKeystorePass(ssl.getKeyStorePassword());
		protocol.setKeyPass(ssl.getKeyPassword());
		protocol.setKeyAlias(ssl.getKeyAlias());
		final String ciphers = StringUtils.arrayToCommaDelimitedString(ssl.getCiphers());
		if (StringUtils.hasText(ciphers)) {
			protocol.setCiphers(ciphers);
		}
		if (ssl.getEnabledProtocols() != null) {
			for (final SSLHostConfig config : protocol.findSslHostConfigs()) {
				config.setProtocols(StringUtils.arrayToCommaDelimitedString(ssl.getEnabledProtocols()));
			}
		}
		if (provider != null) {
			configureSslStoreProvider(protocol, provider);
		} else {
			configureSslKeyStore(protocol, ssl);
			configureSslTrustStore(protocol, ssl);
		}
	}

	private void configureSslClientAuth(final AbstractHttp11JsseProtocol<?> protocol, final Ssl ssl) {
		if (ssl.getClientAuth() == Ssl.ClientAuth.NEED) {
			protocol.setClientAuth(Boolean.TRUE.toString());
		} else if (ssl.getClientAuth() == Ssl.ClientAuth.WANT) {
			protocol.setClientAuth("want");
		}
	}

	protected void configureSslStoreProvider(final AbstractHttp11JsseProtocol<?> protocol, final SslStoreProvider provider) {
		final TomcatURLStreamHandlerFactory instance = TomcatURLStreamHandlerFactory.getInstance();
		instance.addUserFactory(new SslKeyStoreStreamFactory(provider));
		try {
			if (provider.getKeyStore() != null) {
				protocol.setKeystorePass("");
				protocol.setKeystoreFile(SslKeyStoreStreamFactory.KEY_STORE);
			}
			if (provider.getTrustStore() != null) {
				protocol.setTruststorePass("");
				protocol.setTruststoreFile(SslKeyStoreStreamFactory.TRUST_STORE);
			}
		} catch (final Exception e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	private void configureSslKeyStore(final AbstractHttp11JsseProtocol<?> protocol, final Ssl ssl) {
		try {
			protocol.setKeystoreFile(ResourceUtils.getURL(ssl.getKeyStore()).toString());
		} catch (final FileNotFoundException e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		}
		if (ssl.getKeyStoreType() != null) {
			protocol.setKeystoreType(ssl.getKeyStoreType());
		}
		if (ssl.getKeyStoreProvider() != null) {
			protocol.setKeystoreProvider(ssl.getKeyStoreProvider());
		}
	}

	private void configureSslTrustStore(final AbstractHttp11JsseProtocol<?> protocol, final Ssl ssl) {
		if (ssl.getTrustStore() != null) {
			try {
				protocol.setTruststoreFile(ResourceUtils.getURL(ssl.getTrustStore()).toString());
			} catch (final FileNotFoundException e) {
				log.error(e.getMessage(), e);
				throw new RuntimeException(e.getMessage(), e);
			}
		}
		protocol.setTruststorePass(ssl.getTrustStorePassword());
		if (ssl.getTrustStoreType() != null) {
			protocol.setTruststoreType(ssl.getTrustStoreType());
		}
		if (ssl.getTrustStoreProvider() != null) {
			protocol.setTruststoreProvider(ssl.getTrustStoreProvider());
		}
	}
}