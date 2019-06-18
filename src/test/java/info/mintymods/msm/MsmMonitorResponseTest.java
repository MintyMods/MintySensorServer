package info.mintymods.msm;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import info.mintymods.utils.MintyJsonUtils;

public class MsmMonitorResponseTest {

	@Test
	public void testToStringReturnsValidJson() {
		MsmMonitorResponse response = new MsmMonitorResponse();
		assertTrue(MintyJsonUtils.isValidJSON(response.toString()));
	}

}
