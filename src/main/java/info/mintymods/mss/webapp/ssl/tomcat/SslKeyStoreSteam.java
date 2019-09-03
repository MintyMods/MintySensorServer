package info.mintymods.mss.webapp.ssl.tomcat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SslKeyStoreSteam extends URLConnection {

	private static final Logger log = LoggerFactory.getLogger(SslKeyStoreSteam.class);
	private final KeyStore keyStore;

	SslKeyStoreSteam(final URL url, final KeyStore keyStore) {
		super(url);
		this.keyStore = keyStore;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		try (ByteArrayOutputStream stream = new ByteArrayOutputStream()) {
			keyStore.store(stream, new char[0]);
			return new ByteArrayInputStream(stream.toByteArray());
		} catch (KeyStoreException | NoSuchAlgorithmException | CertificateException e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	@Override
	public void connect() throws IOException {
	}
}
