package info.mintymods.jni;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import info.mintymods.msm.MsmMonitorRequest;
import info.mintymods.mss.webapp.exception.MsmMissingDependencyExceprion;
import info.mintymods.utils.MintyPathUtils;

public class MsmJniWrapper {

	public static final boolean DEBUG = false;
	private static final String SOURCE = "MSM[JSON]EXAMPLE";
	private static final Logger log = LoggerFactory.getLogger(MsmJniWrapper.class);
	private static final String[] libraries = {"log4net", "Newtonsoft.Json", "MintyServiceHWiNFO", "MintySensorMonitor", "MintySm2MintySsJniWrapper"};
	static {
		try {
			log.info("@JAVA_HOME#" + MintyPathUtils.getJavaHomeDirectory());
			deployRuntimeDependenciesToJavaHome();
			loadRuntimeDependencies();
		} catch (final Exception e) {
			log.error("@FAILED TO LOAD NATIVE CODE#" + e.getMessage());
		}
	}

	private static void deployRuntimeDependenciesToJavaHome() {
		log.info("Deploying dependencies into " + getJavaBinDirectory());
		try {
			for (final Resource resource : getDllResources()) {
				FileUtils.copyFile(resource.getFile(), getJavaBinDirectoryTarget(resource));
			}
		} catch (final IOException e) {
			log.error("@Deploy-Failed#" + e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			for (final Resource resource : getDllResources()) {
				final File deploy = new File(getJavaBinDirectory(), resource.getFilename());
				log.info("@" + deploy.getAbsolutePath() + "#Deployed");
				deploy.deleteOnExit();
			}
		}
	}

	private static File getJavaBinDirectoryTarget(final Resource resource) {
		return new File(getJavaBinDirectory() + File.separator + resource.getFilename());
	}

	private static Resource[] getDllResources() {
		final PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource[] resources;
		try {
			resources = resolver.getResources("/**/*.dll");
		} catch (final IOException e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		}
		if (resources.length == 0) {
			throw new MsmMissingDependencyExceprion();
		}
		return resources;
	}

	private static File getJavaBinDirectory() {
		return new File(MintyPathUtils.getJavaHomeDirectory() + File.separator + "bin");
	}

	private static File getRuntimeLibDirectory() {
		return new File(MintyPathUtils.getRuntimeLibDirectory());
	}

	private static void loadRuntimeDependencies() throws Exception {
		log.info("@PATH#" + System.getProperty("java.library.path"));
		for (final String lib : libraries) {
			System.loadLibrary(lib);
			log.info(lib + ".dll loaded");
		}
	}

	public static void main(final String[] args) {
		final MsmJniWrapper msm = new MsmJniWrapper();
		log.info("@MSM#" + msm);
		final MsmMonitorRequest request = new MsmMonitorRequest();
		request.setSource(SOURCE);
		request.setDebug(DEBUG);
		log.info("@request#" + request.toString());
		for (int i = 0; i < 150; i++) {
			final String response = msm.processRequest(request.toString());
			log.info("Response :: " + response);
		}
	}

	protected native String processRequest(String json);
}
