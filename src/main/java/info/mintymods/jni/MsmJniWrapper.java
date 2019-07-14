package info.mintymods.jni;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import info.mintymods.msm.MsmMonitorRequest;

public class MsmJniWrapper {

	private static final boolean DEBUG = true;
	// private static final String SOURCE = "MSM[JSON]EXAMPLE";
	private static final String SOURCE = "MSM[JSON]HWiNFO";
	private static final Logger log = LoggerFactory.getLogger(MsmJniWrapper.class);
	private static final String JAVA_HOME = System.getProperty("java.home");
	private static final String[] libraries = {"log4net", "Newtonsoft.Json", "MintyServiceHWiNFO", "MintySensorMonitor", "MintySm2MintySsJniWrapper"};
	static {
		try {
			log.info("@JAVA_HOME#" + JAVA_HOME);
			deployRuntimeDependenciesToJavaHome();
			loadRuntimeDependencies();
		} catch (final Exception e) {
			log.error("@FAILED TO LOAD NATIVE CODE#" + e.getMessage());
		}
	}

	private static void deployRuntimeDependenciesToJavaHome() {
		log.info("Deploying dependencies into " + getJavaBinDirectory());
		try {
			FileUtils.copyDirectory(getRuntimeLibDirectory(), getJavaBinDirectory(), (FileFilter) pathname -> pathname.getName().endsWith(".dll"));
		} catch (final IOException e) {
			log.error("#Deploy-Failed@" + e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			final String[] dependencies = getRuntimeLibDirectory().list((dir, name) -> name.endsWith(".dll"));
			for (final String dependency : dependencies) {
				final File deploy = new File(getJavaBinDirectory(), dependency);
				log.info("#" + deploy.getAbsolutePath() + "@Deployed");
				deploy.deleteOnExit();
			}
		}
	}

	private static File getJavaBinDirectory() {
		return new File(JAVA_HOME + File.separator + "bin");
	}

	private static File getRuntimeLibDirectory() {
		// TODO Auto-generated method stub
		return new File("E:\\Development\\MintySensorServer\\src\\main\\resources\\lib");
	}

	private static void loadRuntimeDependencies() throws Exception {
		log.info("@PATH#" + System.getProperty("java.library.path"));
		for (final String lib : libraries) {
			System.loadLibrary(lib);
			log.info(lib + ".dll loaded");
		}
	}

	public static void main(String[] args) {
		final MsmJniWrapper msm = new MsmJniWrapper();
		log.info("@MSM#" + msm);
		final MsmMonitorRequest request = new MsmMonitorRequest();
		request.setSource(SOURCE);
		request.setDebug(DEBUG);
		log.info("@request#" + request.toString());
		for (int i = 0; i < 6500; i++) {
			final String response = msm.processRequest(request.toString());
			log.info("Response :: " + response);
		}
	}

	public native String processRequest(String json);
}
