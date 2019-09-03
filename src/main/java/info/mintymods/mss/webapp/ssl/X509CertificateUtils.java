package info.mintymods.mss.webapp.ssl;

import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyPair;
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

public class X509CertificateUtils {

	public static X509Certificate[] getSelfSignedX509Certificate(final KeyPair keypair, final SecureRandom random)
			throws Exception {
		final X509v3CertificateBuilder certificate = populateCertificateFields(random, keypair);
		final X509CertificateHolder holder = createBouncyCastleCertificate(keypair, certificate);
		final X509Certificate x509 = convertToJreCompatibleCertificate(holder);
		final X509Certificate[] certificates = {x509};
		return certificates;
	}

	private static X509Certificate convertToJreCompatibleCertificate(final X509CertificateHolder holder)
			throws CertificateException {
		final JcaX509CertificateConverter converter = new JcaX509CertificateConverter();
		converter.setProvider(new BouncyCastleProvider());
		final X509Certificate x509 = converter.getCertificate(holder);
		return x509;
	}

	private static X509CertificateHolder createBouncyCastleCertificate(final KeyPair keypair,
			final X509v3CertificateBuilder certificate) throws OperatorCreationException {
		final ContentSigner signer = new JcaContentSignerBuilder("SHA256withECDSA").build(keypair.getPrivate());
		final X509CertificateHolder holder = certificate.build(signer);
		return holder;
	}

	private static X509v3CertificateBuilder populateCertificateFields(final SecureRandom random, final KeyPair keypair)
			throws CertIOException, IOException {
		final X500Name subject = new X500NameBuilder(BCStyle.INSTANCE).addRDN(BCStyle.CN, SslConfig.getDomainName()).build();
		final byte[] id = new byte[20];
		random.nextBytes(id);
		final BigInteger serial = new BigInteger(160, random);
		final X509v3CertificateBuilder certificate = new JcaX509v3CertificateBuilder(subject, serial,
				Date.from(LocalDate.of(2000, 1, 1).atStartOfDay(ZoneOffset.UTC).toInstant()),
				Date.from(LocalDate.of(2035, 1, 1).atStartOfDay(ZoneOffset.UTC).toInstant()), subject,
				keypair.getPublic());
		certificate.addExtension(Extension.subjectKeyIdentifier, false, id);
		certificate.addExtension(Extension.authorityKeyIdentifier, false, id);
		final BasicConstraints constraints = new BasicConstraints(true);
		certificate.addExtension(Extension.basicConstraints, true, constraints.getEncoded());
		final KeyUsage usage = new KeyUsage(KeyUsage.keyCertSign | KeyUsage.digitalSignature);
		certificate.addExtension(Extension.keyUsage, false, usage.getEncoded());
		final ExtendedKeyUsage usageEx = new ExtendedKeyUsage(
				new KeyPurposeId[]{KeyPurposeId.id_kp_serverAuth, KeyPurposeId.id_kp_clientAuth});
		certificate.addExtension(Extension.extendedKeyUsage, false, usageEx.getEncoded());
		return certificate;
	}
}
