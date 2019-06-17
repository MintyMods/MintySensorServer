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

import info.mintymods.mss.Constants;
import info.mintymods.mss.utils.MssFileUtils;
import info.mintymods.mss.utils.ssl.CertificateUtils;

public class CertificateUtilsTest {

	private static final Logger log = LoggerFactory.getLogger(CertificateUtilsTest.class);

	@Test
	public void checkKeystoreExistsOrCreateTest() {
		CertificateUtils.checkKeystoreExistsOrCreate();
		try {
			File file = MssFileUtils.getKeyStoreFile();
			assertTrue(file.exists());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	@Test
	public void createKeyStoreAndImportCertificateTest() {
		SecureRandom random = new SecureRandom();
		KeyPair keyPair;
		Certificate stored;
		try {
			keyPair = CertificateUtils.createKeyPair(random);
			X509Certificate[] certificate = CertificateUtils.getSelfSignedX509Certificate(keyPair, random);
			CertificateUtils.createKeyStoreAndImportCertificate(keyPair.getPrivate(), certificate);
			File file = MssFileUtils.getKeyStoreFile();
			assertTrue(file.exists());
			KeyStore keyStore = KeyStore.getInstance("JKS");
			keyStore.load(new FileInputStream(file), Constants.PASSWORD);
			stored = keyStore.getCertificate(Constants.SSL_ALIAS);
			assertNotNull(stored);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	@Test
	public void generateSelfSignedX509CertificateTest() {
		KeyPair keyPair;
		SecureRandom random = new SecureRandom();
		try {
			keyPair = CertificateUtils.createKeyPair(random);
			assertNotNull(keyPair);
			X509Certificate[] certificate = CertificateUtils.getSelfSignedX509Certificate(keyPair, random);
			assertNotNull(certificate);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	@Test
	public void createKeyPairTest() {
		KeyPair keyPair;
		try {
			keyPair = CertificateUtils.createKeyPair(new SecureRandom());
		} catch (NoSuchAlgorithmException e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		}
		assertNotNull(keyPair);
		assertNotNull(keyPair.getPrivate());
		assertNotNull(keyPair.getPublic());
	}

}
