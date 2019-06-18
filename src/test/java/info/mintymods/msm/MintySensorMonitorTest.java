package info.mintymods.msm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import info.mintymods.MintySensorMonitor;
import info.mintymods.utils.MintyJsonUtils;

public class MintySensorMonitorTest {

	private static final boolean DEBUG = true;
	private static final String SOURCE = "MSM[JSON]EXAMPLE"; // "MSM[JSON]HWiNFO"
	private MintySensorMonitor monitor;
	private MsmMonitorRequest request;

	@Before
	public void setUp() throws Exception {
		monitor = new MintySensorMonitor();
		request = new MsmMonitorRequest();
		request.setSource(SOURCE);
		request.setDebug(DEBUG);
	}

	@After
	public void tearDown() throws Exception {
		monitor = null;
	}

	@Test
	public void initTest() {
		MintySensorMonitor.init();
	}

	@Test
	public void getJsonRequestTest() {
		String json = MintySensorMonitor.getJsonRequest(request);
		assertTrue(MintyJsonUtils.isValidJSON(json));
	}

	@Test
	public void MsmMonitorRequestTest() {
		assertNotNull(request);
	}

	@Test
	public void MsmMonitorRequestSourceTest() {
		String source = request.getSource();
		assertNotNull(source);
		int start = SOURCE.indexOf("[");
		int end = SOURCE.indexOf("]");
		String prefix = SOURCE.substring(0, start);
		String protocol = SOURCE.substring(start + 1, end);
		String service = SOURCE.substring(end + 1, SOURCE.length());
		assertTrue(StringUtils.startsWith(source, prefix));
		assertTrue(StringUtils.contains(source, "[" + protocol + "]"));
		assertTrue(StringUtils.endsWith(source, service));
	}

	@Test
	public void MsmMonitorRequestDebugTest() {
		assertNotNull(request.isDebug());
		if (DEBUG) {
			assertTrue(request.isDebug());
		} else {
			assertFalse(request.isDebug());
		}
	}

	@Test
	public void MsmMonitorRequestTypeTest() {
		assertNotNull(request.getType());
		assertEquals("info.mintymods.msm.MsmMonitorRequest", request.getType());
		String type = "invalidType";
		request = new MsmMonitorRequest();
		request.setType(type);
		String json = MintySensorMonitor.getJsonRequest(request);
		assertNotNull(request);
		assertTrue(StringUtils.contains(json, type));
	}

	@Test
	public void MsmMonitorRequestToStringTest() {
		assertTrue(MintyJsonUtils.isValidJSON(request.toString()));
	}

}
