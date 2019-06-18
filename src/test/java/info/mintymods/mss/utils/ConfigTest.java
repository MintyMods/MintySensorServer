package info.mintymods.mss.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import info.mintymods.mss.MintyConstants;
import info.mintymods.utils.MintyProperties;

public class ConfigTest {

	private static MintyProperties config = MintyProperties.getInstance();

	@Test
	public void testGettingDefaultStringPropertyFromConfig() {
		assertEquals(config.getString("application.name"), MintyConstants.APP_SHORT_NAME);
	}

	@Test
	public void testGettingNullForUnknownPropertyFromConfig() {
		assertEquals(config.getString("should.not.exist"), null);
	}

}
