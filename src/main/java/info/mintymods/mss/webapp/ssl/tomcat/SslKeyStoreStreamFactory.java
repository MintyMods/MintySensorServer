package info.mintymods.mss.webapp.ssl.tomcat;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.server.SslStoreProvider;

public class SslKeyStoreStreamFactory implements URLStreamHandlerFactory {

	private static final Logger log = LoggerFactory.getLogger(SslKeyStoreStreamFactory.class);
	private static final String PROTOCOL = "springbootssl";
	public static final String KEY_STORE = PROTOCOL + ":keyStore";
	public static final String TRUST_STORE = PROTOCOL + ":trustStore";
	private final SslStoreProvider provider;

	public SslKeyStoreStreamFactory(final SslStoreProvider provider) {
		this.provider = provider;
	}

	@Override
	public URLStreamHandler createURLStreamHandler(final String protocol) {
		if (PROTOCOL.equals(protocol)) {
			return new URLStreamHandler() {

				@Override
				protected URLConnection openConnection(final URL url) throws IOException {
					try {
						if (KEY_STORE.equals(url.getPath())) {
							return new SslKeyStoreSteam(url, getProvider().getKeyStore());
						} else if (TRUST_STORE.equals(url.getPath())) {
							return new SslKeyStoreSteam(url, getProvider().getTrustStore());
						} else {
							throw new RuntimeException("Unable to locate path '" + url.getPath() + "'");
						}
					} catch (final Exception e) {
						log.error(e.getMessage(), e);
						throw new RuntimeException(e.getMessage(), e);
					}
				}
			};
		}
		return null;
	}

	public SslStoreProvider getProvider() {
		return provider;
	}
}