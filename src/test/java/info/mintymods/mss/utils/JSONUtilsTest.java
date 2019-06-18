package info.mintymods.mss.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import info.mintymods.msm.MsmMonitorRequest;
import info.mintymods.msm.MsmMonitorResponse;
import info.mintymods.utils.MintyJsonUtils;

public class JSONUtilsTest {

	@Test
	public void getMapperTest() {
		assertNotNull(MintyJsonUtils.getMapper());
	}

	@Test
	public void getMsmMonitorResponseTest() {
		MsmMonitorRequest request = new MsmMonitorRequest();
		String json = MintyJsonUtils.getJsonString(request);
		assertTrue(MintyJsonUtils.isValidJSON(json));
		MsmMonitorResponse response = MintyJsonUtils.getMsmMonitorResponse(json);
		assertNotNull(response);
	}

	@Test
	public void getJsonStringTest() {
		MsmMonitorRequest request = new MsmMonitorRequest();
		String json = MintyJsonUtils.getJsonString(request);
		assertTrue(MintyJsonUtils.isValidJSON(json));
	}

	@Test
	public void isValidJSONTest() {

		assertTrue(MintyJsonUtils.isValidJSON("{}")); // {"source":"MSM[JSON]HWiNFO",
		assertTrue(MintyJsonUtils.isValidJSON("{ \"source\":\"MSM[JSON]HWiNFO\", \"debug\":\"true\" }"));
		assertFalse(MintyJsonUtils.isValidJSON("{"));

	}

}
