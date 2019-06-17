package info.mintymods.msm;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import info.mintymods.msm.MsmSensorReading;
import info.mintymods.mss.utils.MssJSONUtils;

public class MsmSensorReadingTest {

	@Test
	public void testToStringReturnsValidJson() {
		assertTrue(MssJSONUtils.isValidJSON(new MsmSensorReading().toString()));
	}

}
