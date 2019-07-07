package info.mintymods.jni;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import info.mintymods.msm.MsmMonitorRequest;

public class MsmJniWrapper {

	private static final boolean DEBUG = true;
	private static final String SOURCE = "MSM[JNI]EXAMPLE"; // "MSM[JSON]HWiNFO"
	private static final Logger log = LoggerFactory.getLogger(MsmJniWrapper.class);
	static {
		try {
			System.out.println(System.getProperty("java.library.path"));
			// System.loadLibrary("E:/Development/MintySensorServerGradle/bin/main/lib/MintySm2MintySsJniWrapper.dll");
			System.loadLibrary("MintySm2MintySsJniWrapper");
		} catch (final UnsatisfiedLinkError e) {
			System.err.println("Native code library failed to load.\n" + e);
			System.exit(1);
		}
	}

	public static void main(String[] args) {
		final MsmJniWrapper msm = new MsmJniWrapper();
		final MsmMonitorRequest request = new MsmMonitorRequest();
		request.setSource(SOURCE);
		request.setDebug(DEBUG);
		final String response = msm.processRequest(request.toString());
		System.out.println("Response :: " + response);
	}

	public native String processRequest(String json);
}
