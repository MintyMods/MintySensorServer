package info.mintymods.msm;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import info.mintymods.utils.MintyJsonUtils;

public class MsmSensorTypeTest {

	@Test
	public void testToStringReturnsValidJsonNone() {
		assertTrue(MintyJsonUtils.isValidJSON(MsmSensorType.NONE.toString()));
	}

	@Test
	public void testToStringReturnsValidJsonClock() {
		assertTrue(MintyJsonUtils.isValidJSON(MsmSensorType.CLOCK.toString()));
	}

	@Test
	public void testToStringReturnsValidJsonCurrent() {
		assertTrue(MintyJsonUtils.isValidJSON(MsmSensorType.CURRENT.toString()));
	}

	@Test
	public void testToStringReturnsValidJsonFan() {
		assertTrue(MintyJsonUtils.isValidJSON(MsmSensorType.FAN.toString()));
	}

	@Test
	public void testToStringReturnsValidJsonOther() {
		assertTrue(MintyJsonUtils.isValidJSON(MsmSensorType.OTHER.toString()));
	}

	@Test
	public void testToStringReturnsValidJsonPower() {
		assertTrue(MintyJsonUtils.isValidJSON(MsmSensorType.POWER.toString()));
	}

	@Test
	public void testToStringReturnsValidJsonTemp() {
		assertTrue(MintyJsonUtils.isValidJSON(MsmSensorType.TEMP.toString()));
	}

	@Test
	public void testToStringReturnsValidJsonUsage() {
		assertTrue(MintyJsonUtils.isValidJSON(MsmSensorType.USAGE.toString()));
	}

	@Test
	public void testToStringReturnsValidJsonVolt() {
		assertTrue(MintyJsonUtils.isValidJSON(MsmSensorType.VOLT.toString()));
	}

}
