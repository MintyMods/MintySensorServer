package info.mintymods.msm;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import info.mintymods.utils.MintyJsonUtils;

public class MsmSensorReadingTest {

	@Test
	public void testToStringReturnsValidJson() {
		assertTrue(MintyJsonUtils.isValidJSON(new MsmSensorReading().toString()));
	}

}
