package info.mintymods.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MssPathUtils {

	private static final Logger log = LoggerFactory.getLogger(MssPathUtils.class);
	private static final String FILENAME_LOG4BACK_XML = "logback.xml";
	private static final String FILENAME_CROSSDOMAIN_XML = "crossdomain.xml";
	private static final String FILENAME_DATA_SQL = "data.sql";
	private static final String FILENAME_PROPERTIES = MintyProperties.MSS_PROPERTIES;
	private static final String ROOT_FOLDER_PATH = "E:/Development/MintySS";
	private static final String BIN_FOLDER_PATH = ROOT_FOLDER_PATH + "/bin/";
	private static final String CLASSES_FOLDER_PATH = ROOT_FOLDER_PATH + "/src/main/resources";
	private static final String RUNTIME_CLASSES_FOLDER_PATH = ROOT_FOLDER_PATH + "/target/classes/";
	private static final String RUNTIME_BIN_FOLDER_PATH = ROOT_FOLDER_PATH + "/target/classes/";
	private static final String DLL_FILENAME_LOG4NET = "log4net.dll";
	private static final String DLL_FILENAME_MINTY_SERVICE_HWINFO = "MintyServiceHWiNFO.dll";
	private static final String FILENAME_MAVEN_WRAPPER = "maven-wrapper.jar";
	private static final String FILENAME_MAVEN_WRAPPER_DOWNLOADER = "MavenWrapperDownloader.class";
	private static final String RUNTIME_KEYSTORE_FOLDER_PATH = ROOT_FOLDER_PATH + "/target/classes/keystore/";

	public static String getApplicationPropertiesFilename() {
		return FILENAME_PROPERTIES;
	}

	public static String getBinFolder() {
		return BIN_FOLDER_PATH;
	}

	public static String getClassesFolder() {
		return CLASSES_FOLDER_PATH;
	}

	public static String getCrossDomainXmlFilename() {
		return FILENAME_CROSSDOMAIN_XML;
	}

	public static String getDataSqlFilename() {
		return FILENAME_DATA_SQL;
	}

	public static String getLog4NetDllFilename() {
		return DLL_FILENAME_LOG4NET;
	}

	public static String getLogBackXmlFilename() {
		return FILENAME_LOG4BACK_XML;
	}

	public static String getMavenWrapperDownloaderFilename() {
		return FILENAME_MAVEN_WRAPPER_DOWNLOADER;
	}

	public static String getMavenWrapperFilename() {
		return FILENAME_MAVEN_WRAPPER;
	}

	public static String getMintyServiceHWiNFODLLFilename() {
		return DLL_FILENAME_MINTY_SERVICE_HWINFO;
	}

	public static String getRootFolder() {
		return ROOT_FOLDER_PATH;
	}

	public static String getRuntimeBinFolderPath() {
		return RUNTIME_BIN_FOLDER_PATH;
	}

	public static String getRuntimeClassesFolder() {
		return RUNTIME_CLASSES_FOLDER_PATH;
	}

	public static String getRuntimeKeyStoreFolder() {
		return RUNTIME_KEYSTORE_FOLDER_PATH;
	}
}
