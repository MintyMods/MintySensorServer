package info.mintymods.mss.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import info.mintymods.utils.MintyFileUtils;
import info.mintymods.utils.MssPathUtils;

public class UtilsTest {

	@Test
	public void getPathToMintySensorMonitor() {
		// File file = new File(Utils.getPathToMintySensorMonitor());
		File file = MintyFileUtils.getFileFromLibPath(MssPathUtils.getMintySensorMonitorFilename());
		assertTrue(file.exists());
		assertTrue(file.getName().endsWith(".exe"));
	}

	@Test
	public void getAbsolutePath() {
		String path = MintyFileUtils.getFileFromClassPath(MssPathUtils.getApplicationPropertiesFilename())
				.getAbsolutePath();
		assertNotNull(path);
		File file = new File(path);
		assertNotNull(file);
		assertTrue(file.exists());
		File realFile = new File(
				MssPathUtils.getRuntimeClassesFolder() + File.separator
						+ MssPathUtils.getApplicationPropertiesFilename());
		assertNotNull(realFile);
		assertTrue(realFile.exists());
		assertEquals(realFile.getAbsoluteFile(), file.getAbsoluteFile());
	}

	@Test
	public void getCanonicalPath() {

		try {
			String path = MintyFileUtils.getFileFromClassPath(MssPathUtils.getApplicationPropertiesFilename())
					.getCanonicalPath();
			assertNotNull(path);
			File file = new File(path);
			assertNotNull(file);
			assertTrue(file.exists());
			File realFile = new File(MssPathUtils.getRuntimeClassesFolder() + File.separator
					+ MssPathUtils.getApplicationPropertiesFilename());
			assertNotNull(realFile);
			assertTrue(realFile.exists());
			assertEquals(realFile.getCanonicalFile(), file.getCanonicalFile());
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	@Test
	public void getFileFromClassPath() {
		File fileFromClassPath = MintyFileUtils.getFileFromClassPath(MssPathUtils.getApplicationPropertiesFilename());
		assertTrue(fileFromClassPath.exists());
	}

}
