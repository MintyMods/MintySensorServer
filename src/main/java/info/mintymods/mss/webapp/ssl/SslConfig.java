package info.mintymods.mss.webapp.ssl;

public class SslConfig {

	public static String getDomainName() {
		return "MintyMods.info";
	}

	public static char[] getPassword() {
		return "M!nTyS3ns0rS3v3rPassw0rd".toCharArray();
	}

	public static String getName() {
		return "mss";
	}

	public static String getKeyAlias() {
		return "MintySensorServer";
	}

	public static String getKeyPassword() {
		return String.valueOf(getPassword());
	}

	public static String getKeyStore() {
		return "E:/Development/MintySS/target/classes/keystore/mss.keystore";
	}

	public static String getKeyStoreType() {
		return "JKS";
	}

	public static String getKeyStoreProvider() {
		return "SUN";
	}
}
