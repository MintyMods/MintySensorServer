package info.mintymods.mss.utils;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

import info.mintymods.utils.MintyFileUtils;
import info.mintymods.utils.MssPathUtils;

public class PathUtilsTest {

	@Test
	public void FileExistsApplicationPropertiesTest() {
		final File fileFromClassPath = MintyFileUtils.getFileFromClassPath(MssPathUtils.getApplicationPropertiesFilename());
		assertNotNull(fileFromClassPath);
		assertTrue(fileFromClassPath.exists());
	}

	@Test
	public void FileExistsCrossDomainXmlTest() {
		final File fileFromClassPath = MintyFileUtils.getFileFromClassPath(MssPathUtils.getCrossDomainXmlFilename());
		assertNotNull(fileFromClassPath);
		assertTrue(fileFromClassPath.exists());
	}

	@Test
	public void FileExistsDataSqlTest() {
		// File fileFromClassPath = FileUtils.getFileFromClassPath(PathUtils.getDataSqlFilename());
		// assertNotNull(fileFromClassPath);
		// assertTrue(fileFromClassPath.exists());
	}

	@Test
	public void FileExistsLog4NetDllTest() {
		final File fileFromBinPath = MintyFileUtils.getFileFromLibPath(MssPathUtils.getLog4NetDllFilename());
		assertNotNull(fileFromBinPath);
		assertTrue(fileFromBinPath.exists());
	}

	@Test
	public void FileExistsLogBackXmlTest() {
		final File fileFromClassPath = MintyFileUtils.getFileFromClassPath(MssPathUtils.getLogBackXmlFilename());
		assertNotNull(fileFromClassPath);
		assertTrue(fileFromClassPath.exists());
	}

	// @Test
	// public void FileExistsMavenWrapperTest() {
	// final File fileFromBinPath = MintyFileUtils.getFileFromBinPath(MssPathUtils.getMavenWrapperFilename());
	// assertNotNull(fileFromBinPath);
	// assertTrue(fileFromBinPath.exists());
	// }
	@Test
	public void FileExistsMintyServiceHwinfoTest() {
		final String mintyServiceHWiNFODLLFilename = MssPathUtils.getMintyServiceHWiNFODLLFilename();
		final File fileFromBinPath = MintyFileUtils.getFileFromLibPath(mintyServiceHWiNFODLLFilename);
		assertNotNull(fileFromBinPath);
		assertTrue(fileFromBinPath.exists());
	}
}
