package info.mintymods.msm;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import info.mintymods.msm.MsmException;
import info.mintymods.mss.utils.MssJSONUtils;

public class MsmExceptionTest {

	@Test
	public void testToStringReturnsValidJson() {
		assertTrue(MssJSONUtils.isValidJSON(new MsmException().toString()));
	}

}
