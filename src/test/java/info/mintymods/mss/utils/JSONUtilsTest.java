package info.mintymods.mss.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import info.mintymods.msm.MsmMonitorRequest;
import info.mintymods.msm.MsmMonitorResponse;
import info.mintymods.mss.utils.MssJSONUtils;

public class JSONUtilsTest {

	@Test
	public void getMapperTest() {
		assertNotNull(MssJSONUtils.getMapper());
	}

	@Test
	public void getMsmMonitorResponseTest() {
		MsmMonitorRequest request = new MsmMonitorRequest();
		String json = MssJSONUtils.getJsonString(request);
		assertTrue(MssJSONUtils.isValidJSON(json));
		MsmMonitorResponse response = MssJSONUtils.getMsmMonitorResponse(json);
		assertNotNull(response);
	}

	@Test
	public void getJsonStringTest() {
		MsmMonitorRequest request = new MsmMonitorRequest();
		String json = MssJSONUtils.getJsonString(request);
		assertTrue(MssJSONUtils.isValidJSON(json));
	}

	@Test
	public void isValidJSONTest() {

		assertTrue(MssJSONUtils.isValidJSON("{}")); // {"source":"MSM[JSON]HWiNFO",
		assertTrue(MssJSONUtils.isValidJSON("{ \"source\":\"MSM[JSON]HWiNFO\", \"debug\":\"true\" }"));
		assertFalse(MssJSONUtils.isValidJSON("{"));

	}

}
