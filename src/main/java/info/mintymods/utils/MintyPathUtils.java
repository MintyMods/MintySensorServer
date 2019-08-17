package info.mintymods.utils;

public class MintyPathUtils {

	private static final String FILENAME_CROSSDOMAIN_XML = "crossdomain.xml";
	private static final String FILENAME_PROPERTIES = MintyProperties.MSS_PROPERTIES;
	private static final String ROOT_FOLDER_PATH = "E:/Development/MintySS";
	private static final String BIN_FOLDER_PATH = ROOT_FOLDER_PATH + "/bin/";
	private static final String CLASSES_FOLDER_PATH = ROOT_FOLDER_PATH + "/src/main/resources";
	private static final String RUNTIME_CLASSES_FOLDER_PATH = ROOT_FOLDER_PATH + "/target/classes/";
	private static final String RUNTIME_BIN_FOLDER_PATH = ROOT_FOLDER_PATH + "/target/classes/";
	private static final String DLL_FILENAME_LOG4NET = "log4net.dll";
	private static final String DLL_FILENAME_MINTY_SERVICE_HWINFO = "MintyServiceHWiNFO.dll";
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

	public static String getLog4NetDllFilename() {
		return DLL_FILENAME_LOG4NET;
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
