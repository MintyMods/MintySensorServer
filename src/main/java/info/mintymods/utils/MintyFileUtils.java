package info.mintymods.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

public class MintyFileUtils {

	private static final Logger log = LoggerFactory.getLogger(MintyFileUtils.class);

	public static String getAbsolutePath(final String filename) {
		return getFileFromClassPath(filename).getAbsolutePath();
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

	public static File getFileFromClassPath(final String filename) {
		try {
			return ResourceUtils.getFile("classpath:" + filename);
		} catch (final IOException e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public static File getKeyStoreFile() throws FileNotFoundException {
		final File dir = new File(MintyPathUtils.getRuntimeKeyStoreFolder());
		if (!dir.exists()) {
			dir.mkdirs();
		}
		final File file = new File(MintyPathUtils.getKeyStore());
		return file;
	}
}