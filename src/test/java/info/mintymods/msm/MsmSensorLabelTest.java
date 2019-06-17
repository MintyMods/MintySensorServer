package info.mintymods.msm;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import info.mintymods.msm.MsmSensorLabel;
import info.mintymods.mss.utils.MssJSONUtils;

public class MsmSensorLabelTest {

	@Test
	public void testToStringReturnsValidJson() {
		assertTrue(MssJSONUtils.isValidJSON(new MsmSensorLabel().toString()));
	}
}
