package info.mintymods.mss.utils;

import org.junit.Test;

import info.mintymods.mss.webapp.config.properties.MintyConfig;

public class ConfigTest {

	private static MintyConfig config = MintyConfig.getInstance();

	@Test
	public void testGettingDefaultStringPropertyFromConfig() {
		// assertEquals(config.getString("application.name"), MintyConstants.APP_SHORT_NAME);
	}

	@Test
	public void testGettingNullForUnknownPropertyFromConfig() {
		// assertEquals(config.getString("should.not.exist"), null);
	}
}
