package info.mintymods.mss;

public class Constants {

	public static final String APP_SHORT_NAME = "mss";

	public static final String APP_TITLE = "Mintys Sensor Server";

	public static final String APP_VERSION = "1.0.0";// @todo

	public static final String APP_DESCRIPTION = APP_SHORT_NAME + " - " + APP_TITLE
			+ " - RESTful Service exposing hardware sensor information from HWiNFO";

	public static final String DEFAULT_PORT_HTTP = "8080";

	public static final String WAR_FILENAME = APP_SHORT_NAME + ".war";

	public static final String AUTHORIZATION_TYPE_BASIC = "Basic ";

	public static final String CONTENT_ENCODING = "UTF-8";

	public static final String TEMP_FILE_PREFIX = APP_SHORT_NAME + "_TomcatEmbedded";

	public static final char[] PASSWORD = "M!nTyS3ns0rS3v3rPassw0rd".toCharArray();

	public static final String DOMAIN_NAME = "MintyMods.info";

	public static final String SSL_ALIAS = "MintySensorServer";

	public static final String LINE_SEPARATOR = System.getProperty("line.separator");

}
