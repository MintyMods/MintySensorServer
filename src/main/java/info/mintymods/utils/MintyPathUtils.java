package info.mintymods.utils;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.system.ApplicationHome;

import info.mintymods.MintySensorServer;

public class MintyPathUtils {

	private static final Logger log = LoggerFactory.getLogger(MintyPathUtils.class);
	private static final String JAVA_HOME = System.getProperty("java.home");
	private static final String ROOT_FOLDER_PATH = getRootPath();
	private static final String LIB_FOLDER_PATH = ROOT_FOLDER_PATH + "/lib/";
	private static final String RUNTIME_KEYSTORE_FOLDER_PATH = ROOT_FOLDER_PATH + "/target/classes/keystore/";

	public static String getApplicationHomeDirectory() {
		final ApplicationHome home = new ApplicationHome(MintySensorServer.class);
		try {
			return home.getDir().getCanonicalPath();
		} catch (final IOException e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public static String getRootPath() {
		final File home = new File(getApplicationHomeDirectory());
		return home.getParentFile().getParent();
	}

	public static String getRuntimeLibDirectory() {
		return LIB_FOLDER_PATH;
	}

	public static String getRootFolder() {
		return ROOT_FOLDER_PATH;
	}

	public static String getRuntimeKeyStoreFolder() {
		return RUNTIME_KEYSTORE_FOLDER_PATH;
	}

	public static String getJavaHomeDirectory() {
		return JAVA_HOME;
	}

	public static String getKeyStore() {
		return getRuntimeKeyStoreFolder() + getAppName() + ".keystore";
	}

	private static String getAppName() {
		return MintySensorServer.getConfig().getApplication().getName();
	}
}
