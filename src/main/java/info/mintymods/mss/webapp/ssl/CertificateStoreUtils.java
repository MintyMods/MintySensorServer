package info.mintymods.mss.webapp.ssl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import info.mintymods.utils.MintyFileUtils;

public class CertificateStoreUtils {

	private static final Logger log = LoggerFactory.getLogger(CertificateStoreUtils.class);

	public static KeyPair createKeyPair(final SecureRandom random) throws NoSuchAlgorithmException {
		final KeyPairGenerator keypairGen = KeyPairGenerator.getInstance("EC");
		keypairGen.initialize(256, random);
		final KeyPair keypair = keypairGen.generateKeyPair();
		return keypair;
	}

	public static void checkKeystoreExistsOrCreate() {
		try {
			final KeyStore keyStore = KeyStore.getInstance("JKS");
			final File file = MintyFileUtils.getKeyStoreFile();
			if (file.exists()) {
				try (FileInputStream stream = new FileInputStream(file)) {
					// keyStore.load(stream, MintyConstants.PASSWORD);
					keyStore.load(stream, SslConfig.getPassword());
					if (!keyStore.containsAlias(SslConfig.getKeyAlias())) {
						createKeyStoreAndImportCertificate();
					}
				}
			} else {
				createKeyStoreAndImportCertificate();
			}
		} catch (final Exception e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public static void createKeyStoreAndImportCertificate() throws Exception {
		final SecureRandom random = new SecureRandom();
		final KeyPair keypair = createKeyPair(random);
		final X509Certificate[] certificates = X509CertificateUtils.getSelfSignedX509Certificate(keypair, random);
		log.info("Creating Keystore");
		createKeyStoreAndImportCertificate(keypair.getPrivate(), certificates);
	}

	public static void createKeyStoreAndImportCertificate(final Key key, final X509Certificate[] certificate) throws Exception {
		final KeyStore keyStore = KeyStore.getInstance("JKS");
		final File file = MintyFileUtils.getKeyStoreFile();
		if (file.exists()) {
			log.debug("Certificate .keystore found @" + file.getAbsolutePath());
			try (FileInputStream stream = new FileInputStream(file)) {
				keyStore.load(stream, SslConfig.getPassword());
			}
		} else {
			log.debug("Certificate .keystore Not found, creating @" + file.getAbsolutePath());
			try (FileOutputStream stream = new FileOutputStream(file)) {
				keyStore.load(null, null);
				keyStore.store(stream, SslConfig.getPassword());
			}
		}
		log.info("Importing Certificate into Keystore");
		importCertificateInKeyStore(key, certificate, keyStore, file);
	}

	private static void importCertificateInKeyStore(final Key key, final X509Certificate[] certificate, final KeyStore keyStore,
			final File file) throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException,
			FileNotFoundException {
		try (FileOutputStream stream = new FileOutputStream(file)) {
			keyStore.setKeyEntry(SslConfig.getKeyAlias(), key, SslConfig.getPassword(), certificate);
			keyStore.store(stream, SslConfig.getPassword());
		}
	}
}
