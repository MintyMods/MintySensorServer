package info.mintymods.mss.utils.ssl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;

import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.X500NameBuilder;
import org.bouncycastle.asn1.x500.style.BCStyle;
import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.asn1.x509.ExtendedKeyUsage;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.KeyPurposeId;
import org.bouncycastle.asn1.x509.KeyUsage;
import org.bouncycastle.cert.CertIOException;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import info.mintymods.mss.Constants;
import info.mintymods.mss.utils.MssFileUtils;

public class CertificateUtils {

	private static final Logger log = LoggerFactory.getLogger(CertificateUtils.class);

	public static KeyPair createKeyPair(SecureRandom random) throws NoSuchAlgorithmException {
		KeyPairGenerator keypairGen = KeyPairGenerator.getInstance("EC");
		keypairGen.initialize(256, random);
		KeyPair keypair = keypairGen.generateKeyPair();
		return keypair;
	}

	public static void checkKeystoreExistsOrCreate() {
		try {
			KeyStore keyStore = KeyStore.getInstance("JKS");
			File file = MssFileUtils.getKeyStoreFile();
			if (file.exists()) {
				keyStore.load(new FileInputStream(file), Constants.PASSWORD);
				if (!keyStore.containsAlias(Constants.SSL_ALIAS)) {
					createKeyStoreAndImportCertificate();
				}
			} else {
				createKeyStoreAndImportCertificate();
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		}

	}

	public static void createKeyStoreAndImportCertificate() throws Exception {
		SecureRandom random = new SecureRandom();
		KeyPair keypair = createKeyPair(random);
		X509Certificate[] certificates = getSelfSignedX509Certificate(keypair, random);
		log.info("Creating Keystore");
		createKeyStoreAndImportCertificate(keypair.getPrivate(), certificates);
	}

	public static void createKeyStoreAndImportCertificate(Key key, X509Certificate[] certificate) throws Exception {
		KeyStore keyStore = KeyStore.getInstance("JKS");
		File file = MssFileUtils.getKeyStoreFile();
		if (file.exists()) {
			log.debug("Certificate .keystore found @" + file.getAbsolutePath());
			keyStore.load(new FileInputStream(file), Constants.PASSWORD);
		} else {
			log.debug("Certificate .keystore Not found, creating @" + file.getAbsolutePath());
			keyStore.load(null, null);
			keyStore.store(new FileOutputStream(file), Constants.PASSWORD);
		}
		log.info("Importing Certificate into Keystore");
		importCertificateInKeyStore(key, certificate, keyStore, file);
	}

	private static void importCertificateInKeyStore(Key key, X509Certificate[] certificate, KeyStore keyStore,
			File file) throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException,
			FileNotFoundException {
		keyStore.setKeyEntry(Constants.SSL_ALIAS, key, Constants.PASSWORD, certificate);
		keyStore.store(new FileOutputStream(file), Constants.PASSWORD);
	}

	public static X509Certificate[] getSelfSignedX509Certificate(KeyPair keypair, SecureRandom random)
			throws Exception {
		X509v3CertificateBuilder certificate = populateCertificateFields(random, keypair);
		X509CertificateHolder holder = createBouncyCastleCertificate(keypair, certificate);
		X509Certificate x509 = convertToJreCompatibleCertificate(holder);
		X509Certificate[] certificates = {x509};
		return certificates;

	}

	private static X509Certificate convertToJreCompatibleCertificate(X509CertificateHolder holder)
			throws CertificateException {
		JcaX509CertificateConverter converter = new JcaX509CertificateConverter();
		converter.setProvider(new BouncyCastleProvider());
		X509Certificate x509 = converter.getCertificate(holder);
		return x509;
	}

	private static X509CertificateHolder createBouncyCastleCertificate(KeyPair keypair,
			X509v3CertificateBuilder certificate) throws OperatorCreationException {
		ContentSigner signer = new JcaContentSignerBuilder("SHA256withECDSA").build(keypair.getPrivate());
		X509CertificateHolder holder = certificate.build(signer);
		return holder;
	}

	private static X509v3CertificateBuilder populateCertificateFields(SecureRandom random, KeyPair keypair)
			throws CertIOException, IOException {
		X500Name subject = new X500NameBuilder(BCStyle.INSTANCE).addRDN(BCStyle.CN, Constants.DOMAIN_NAME).build();
		byte[] id = new byte[20];
		random.nextBytes(id);
		BigInteger serial = new BigInteger(160, random);
		X509v3CertificateBuilder certificate = new JcaX509v3CertificateBuilder(subject, serial,
				Date.from(LocalDate.of(2000, 1, 1).atStartOfDay(ZoneOffset.UTC).toInstant()),
				Date.from(LocalDate.of(2035, 1, 1).atStartOfDay(ZoneOffset.UTC).toInstant()), subject,
				keypair.getPublic());
		certificate.addExtension(Extension.subjectKeyIdentifier, false, id);
		certificate.addExtension(Extension.authorityKeyIdentifier, false, id);
		BasicConstraints constraints = new BasicConstraints(true);
		certificate.addExtension(Extension.basicConstraints, true, constraints.getEncoded());
		KeyUsage usage = new KeyUsage(KeyUsage.keyCertSign | KeyUsage.digitalSignature);
		certificate.addExtension(Extension.keyUsage, false, usage.getEncoded());
		ExtendedKeyUsage usageEx = new ExtendedKeyUsage(
				new KeyPurposeId[]{KeyPurposeId.id_kp_serverAuth, KeyPurposeId.id_kp_clientAuth});
		certificate.addExtension(Extension.extendedKeyUsage, false, usageEx.getEncoded());
		return certificate;
	}

}
