package info.mintymods.mss.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import info.mintymods.mss.Constants;

public class MssFileUtils {

	private static final Logger log = LoggerFactory.getLogger(MssFileUtils.class);

	public static Properties getApplicationProperties() {
		Properties properties = new Properties();
		try {
			File file = getFileFromClassPath(MssPathUtils.getApplicationPropertiesFilename());
			InputStream in = new FileInputStream(file);
			properties.load(in);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		}
		return properties;
	}

	public static String getAbsolutePath(String filename) {
		return getFileFromClassPath(filename).getAbsolutePath();
	}

	public static String getCanonicalPath(String filename) {
		try {
			return getFileFromClassPath(filename).getCanonicalPath();
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public static File getFileFromClassPath(String filename) {
		try {
			return ResourceUtils.getFile("classpath:" + filename);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public static String getPathToMintySensorMonitor() {
		File file = MssFileUtils.getFileFromLibPath(MssPathUtils.getMintySensorMonitorFilename());
		return file.getAbsolutePath();
	}

	public static File getFileFromLibPath(String filename) {
		try {
			return ResourceUtils.getFile("classpath:lib/" + filename);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public static File getFileFromBinPath(String filename) {
		try {
			return ResourceUtils.getFile(MssPathUtils.getBinFolder() + filename);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public static File getKeyStoreFile() throws FileNotFoundException {
		String runtimeKeyStoreFolder = MssPathUtils.getRuntimeKeyStoreFolder();
		File dir = new File(runtimeKeyStoreFolder);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		File file = new File(runtimeKeyStoreFolder + Constants.APP_SHORT_NAME + ".keystore");
		return file;
	}

	public static File getBannerAsciiArt() {
		try {
			return ResourceUtils.getFile("classpath:static/ansi/MintyMods640x480.ansi.txt");
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		}
	}

}