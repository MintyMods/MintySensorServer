package info.mintymods.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import info.mintymods.mss.MintyConstants;

public class MintyFileUtils {

	private static final Logger log = LoggerFactory.getLogger(MintyFileUtils.class);

	public static String getAbsolutePath(final String filename) {
		return getFileFromClassPath(filename).getAbsolutePath();
	}

	public static Properties getApplicationProperties() {
		final Properties properties = new Properties();
		final File file = getFileFromClassPath(MintyPathUtils.getApplicationPropertiesFilename());
		try (InputStream in = new FileInputStream(file)) {
			properties.load(in);
		} catch (final IOException e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		}
		return properties;
	}

	public static File getBannerAsciiArt() {
		try {
			return ResourceUtils.getFile("classpath:static/ansi/MintyMods640x480.ansi.txt");
		} catch (final IOException e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public static String getCanonicalPath(final String filename) {
		try {
			return getFileFromClassPath(filename).getCanonicalPath();
		} catch (final IOException e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public static File getFileFromBinPath(final String filename) {
		try {
			return ResourceUtils.getFile(MintyPathUtils.getBinFolder() + filename);
		} catch (final IOException e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public static File getFileFromClassPath(final String filename) {
		try {
			return ResourceUtils.getFile("classpath:" + filename);
		} catch (final IOException e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public static File getFileFromLibPath(final String filename) {
		try {
			return ResourceUtils.getFile("classpath:lib/" + filename);
		} catch (final IOException e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public static File getKeyStoreFile() throws FileNotFoundException {
		final String runtimeKeyStoreFolder = MintyPathUtils.getRuntimeKeyStoreFolder();
		final File dir = new File(runtimeKeyStoreFolder);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		final File file = new File(runtimeKeyStoreFolder + MintyConstants.APP_SHORT_NAME + ".keystore");
		return file;
	}
}