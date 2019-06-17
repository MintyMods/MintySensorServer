package info.mintymods.msm;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import info.mintymods.msm.MsmSensor;
import info.mintymods.mss.utils.MssJSONUtils;

public class MsmSensorTest {

	@Test
	public void testToStringReturnsValidJson() {
		assertTrue(MssJSONUtils.isValidJSON(new MsmSensor().toString()));
	}

}
