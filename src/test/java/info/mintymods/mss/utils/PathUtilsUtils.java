package info.mintymods.mss.utils;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

import info.mintymods.mss.utils.MssFileUtils;
import info.mintymods.mss.utils.MssPathUtils;

public class PathUtilsUtils {

	@Test
	public void FileExistsApplicationPropertiesTest() {
		File fileFromClassPath = MssFileUtils.getFileFromClassPath(MssPathUtils.getApplicationPropertiesFilename());
		assertNotNull(fileFromClassPath);
		assertTrue(fileFromClassPath.exists());
	}

	@Test
	public void FileExistsCrossDomainXmlTest() {
		File fileFromClassPath = MssFileUtils.getFileFromClassPath(MssPathUtils.getCrossDomainXmlFilename());
		assertNotNull(fileFromClassPath);
		assertTrue(fileFromClassPath.exists());
	}

	@Test
	public void FileExistsDataSqlTest() {
//		File fileFromClassPath = FileUtils.getFileFromClassPath(PathUtils.getDataSqlFilename());
//		assertNotNull(fileFromClassPath);
//		assertTrue(fileFromClassPath.exists());
	}

	@Test
	public void FileExistsLog4jSpringXmlTest() {
		File fileFromClassPath = MssFileUtils.getFileFromClassPath(MssPathUtils.getLog4jSpringXmlFilename());
		assertNotNull(fileFromClassPath);
		assertTrue(fileFromClassPath.exists());
	}

	@Test
	public void FileExistsLogBackXmlTest() {
		File fileFromClassPath = MssFileUtils.getFileFromClassPath(MssPathUtils.getLogBackXmlFilename());
		assertNotNull(fileFromClassPath);
		assertTrue(fileFromClassPath.exists());
	}

	@Test
	public void FileExistsLog4NetDllTest() {
		File fileFromBinPath = MssFileUtils.getFileFromLibPath(MssPathUtils.getLog4NetDllFilename());
		assertNotNull(fileFromBinPath);
		assertTrue(fileFromBinPath.exists());
	}

	@Test
	public void FileExistsMavenWrapperTest() {
		File fileFromBinPath = MssFileUtils.getFileFromBinPath(MssPathUtils.getMavenWrapperFilename());
		assertNotNull(fileFromBinPath);
		assertTrue(fileFromBinPath.exists());
	}

	@Test
	public void FileExistsMavenWrapperDownloaderTest() {
		File fileFromBinPath = MssFileUtils.getFileFromBinPath(MssPathUtils.getMavenWrapperDownloaderFilename());
		assertNotNull(fileFromBinPath);
		assertTrue(fileFromBinPath.exists());
	}

	@Test
	public void FileExistsMintySensorMonitorTest() {
		File fileFromBinPath = MssFileUtils.getFileFromLibPath(MssPathUtils.getMintySensorMonitorFilename());
		assertNotNull(fileFromBinPath);
		assertTrue(fileFromBinPath.exists());
	}

	@Test
	public void FileExistsMintyServiceHwinfoTest() {
		String mintyServiceHWiNFODLLFilename = MssPathUtils.getMintyServiceHWiNFODLLFilename();
		File fileFromBinPath = MssFileUtils.getFileFromLibPath(mintyServiceHWiNFODLLFilename);
		assertNotNull(fileFromBinPath);
		assertTrue(fileFromBinPath.exists());
	}

}
