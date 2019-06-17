package info.mintymods.msm;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import info.mintymods.msm.MsmExceptionHint;
import info.mintymods.mss.utils.MssJSONUtils;

public class MsmExceptionHintTest {

	@Test
	public void testToStringReturnsValidJson() {
		assertTrue(MssJSONUtils.isValidJSON(new MsmExceptionHint().toString()));
	}

}
