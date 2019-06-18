package info.mintymods.msm;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import info.mintymods.utils.MintyJsonUtils;

public class MsmSensorTest {

	@Test
	public void testToStringReturnsValidJson() {
		assertTrue(MintyJsonUtils.isValidJSON(new MsmSensor().toString()));
	}

}
