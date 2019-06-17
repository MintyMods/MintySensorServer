package info.mintymods.msm;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import info.mintymods.msm.MsmMonitorResponse;
import info.mintymods.mss.utils.MssJSONUtils;

public class MsmMonitorResponseTest {

	@Test
	public void testToStringReturnsValidJson() {
		MsmMonitorResponse response = new MsmMonitorResponse();
		assertTrue(MssJSONUtils.isValidJSON(response.toString()));
	}

}
