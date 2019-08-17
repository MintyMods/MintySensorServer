package info.mintymods.mss.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import info.mintymods.msm.MsmMonitorRequest;
import info.mintymods.msm.MsmMonitorResponse;
import info.mintymods.mss.webapp.exception.MsmServiceProviderUnavailableException;
import info.mintymods.utils.MintyJsonUtils;

public class JSONUtilsTest {

	private static final Logger log = LoggerFactory.getLogger(JSONUtilsTest.class);

	@Test
	public void getMapperTest() {
		assertNotNull(MintyJsonUtils.getMapper());
	}

	@Test
	public void getMsmMonitorResponseTest() {
		final MsmMonitorRequest request = new MsmMonitorRequest();
		final String json = MintyJsonUtils.getJsonString(request);
		assertTrue(MintyJsonUtils.isValidJSON(json));
		MsmMonitorResponse response;
		try {
			response = MintyJsonUtils.getMsmMonitorResponse(json);
		} catch (final MsmServiceProviderUnavailableException e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		}
		assertNotNull(response);
	}

	@Test
	public void getJsonStringTest() {
		final MsmMonitorRequest request = new MsmMonitorRequest();
		final String json = MintyJsonUtils.getJsonString(request);
		assertTrue(MintyJsonUtils.isValidJSON(json));
	}

	@Test
	public void isValidJSONTest() {
		assertTrue(MintyJsonUtils.isValidJSON("{}")); // {"source":"MSM[JSON]HWiNFO",
		assertTrue(MintyJsonUtils.isValidJSON("{ \"source\":\"MSM[JSON]HWiNFO\", \"debug\":\"true\" }"));
		assertFalse(MintyJsonUtils.isValidJSON("{"));
	}
}
