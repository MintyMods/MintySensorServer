package info.mintymods.msm;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import info.mintymods.msm.MsmMonitorRequest;
import info.mintymods.mss.utils.MssJSONUtils;

public class MsmMonitorRequestTest {

	@Test
	public void testToStringReturnsValidJson() {
		MsmMonitorRequest request = new MsmMonitorRequest();
		assertTrue(MssJSONUtils.isValidJSON(request.toString()));
	}

}
