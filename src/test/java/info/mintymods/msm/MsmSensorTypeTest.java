package info.mintymods.msm;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import info.mintymods.msm.MsmSensorType;
import info.mintymods.mss.utils.MssJSONUtils;

public class MsmSensorTypeTest {

	@Test
	public void testToStringReturnsValidJsonNone() {
		assertTrue(MssJSONUtils.isValidJSON(MsmSensorType.NONE.toString()));
	}

	@Test
	public void testToStringReturnsValidJsonClock() {
		assertTrue(MssJSONUtils.isValidJSON(MsmSensorType.CLOCK.toString()));
	}

	@Test
	public void testToStringReturnsValidJsonCurrent() {
		assertTrue(MssJSONUtils.isValidJSON(MsmSensorType.CURRENT.toString()));
	}

	@Test
	public void testToStringReturnsValidJsonFan() {
		assertTrue(MssJSONUtils.isValidJSON(MsmSensorType.FAN.toString()));
	}

	@Test
	public void testToStringReturnsValidJsonOther() {
		assertTrue(MssJSONUtils.isValidJSON(MsmSensorType.OTHER.toString()));
	}

	@Test
	public void testToStringReturnsValidJsonPower() {
		assertTrue(MssJSONUtils.isValidJSON(MsmSensorType.POWER.toString()));
	}

	@Test
	public void testToStringReturnsValidJsonTemp() {
		assertTrue(MssJSONUtils.isValidJSON(MsmSensorType.TEMP.toString()));
	}

	@Test
	public void testToStringReturnsValidJsonUsage() {
		assertTrue(MssJSONUtils.isValidJSON(MsmSensorType.USAGE.toString()));
	}

	@Test
	public void testToStringReturnsValidJsonVolt() {
		assertTrue(MssJSONUtils.isValidJSON(MsmSensorType.VOLT.toString()));
	}

}
