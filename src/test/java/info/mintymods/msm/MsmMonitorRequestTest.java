package info.mintymods.msm;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import info.mintymods.utils.MintyJsonUtils;

public class MsmMonitorRequestTest {

	@Test
	public void testToStringReturnsValidJson() {
		MsmMonitorRequest request = new MsmMonitorRequest();
		assertTrue(MintyJsonUtils.isValidJSON(request.toString()));
	}

}
