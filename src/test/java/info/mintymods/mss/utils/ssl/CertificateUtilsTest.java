package info.mintymods.mss.utils.ssl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import info.mintymods.MintySensorServer;
import info.mintymods.mss.webapp.ssl.CertificateStoreUtils;
import info.mintymods.mss.webapp.ssl.X509CertificateUtils;
import info.mintymods.utils.MintyFileUtils;

public class CertificateUtilsTest {

	private static final Logger log = LoggerFactory.getLogger(CertificateUtilsTest.class);

	@Test
	public void checkKeystoreExistsOrCreateTest() {
		CertificateStoreUtils.checkKeystoreExistsOrCreate();
		try {
			final File file = MintyFileUtils.getKeyStoreFile();
			assertTrue(file.exists());
		} catch (final Exception e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	@Test
	public void createKeyStoreAndImportCertificateTest() {
		final SecureRandom random = new SecureRandom();
		KeyPair keyPair;
		Certificate stored;
		try {
			keyPair = CertificateStoreUtils.createKeyPair(random);
			final X509Certificate[] certificate = X509CertificateUtils.getSelfSignedX509Certificate(keyPair, random);
			CertificateStoreUtils.createKeyStoreAndImportCertificate(keyPair.getPrivate(), certificate);
			final File file = MintyFileUtils.getKeyStoreFile();
			assertTrue(file.exists());
			final KeyStore keyStore = KeyStore.getInstance("JKS");
			try (FileInputStream stream = new FileInputStream(file)) {
				keyStore.load(stream, MintySensorServer.getConfig().getPassword());
			}
			stored = keyStore.getCertificate(MintySensorServer.getConfig().getAlias());
			assertNotNull(stored);
		} catch (final Exception e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	@Test
	public void generateSelfSignedX509CertificateTest() {
		KeyPair keyPair;
		final SecureRandom random = new SecureRandom();
		try {
			keyPair = CertificateStoreUtils.createKeyPair(random);
			assertNotNull(keyPair);
			final X509Certificate[] certificate = X509CertificateUtils.getSelfSignedX509Certificate(keyPair, random);
			assertNotNull(certificate);
		} catch (final Exception e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	@Test
	public void createKeyPairTest() {
		KeyPair keyPair;
		try {
			keyPair = CertificateStoreUtils.createKeyPair(new SecureRandom());
		} catch (final NoSuchAlgorithmException e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		}
		assertNotNull(keyPair);
		assertNotNull(keyPair.getPrivate());
		assertNotNull(keyPair.getPublic());
	}
}
