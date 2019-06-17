package info.mintymods.mss.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import info.mintymods.mss.Config;
import info.mintymods.mss.Constants;

public class ConfigTest {

	private static Config config = Config.getInstance();

	@Test
	public void testGettingDefaultStringPropertyFromConfig() {
		assertEquals(config.getString("application.name"), Constants.APP_SHORT_NAME);
	}

	@Test
	public void testGettingNullForUnknownPropertyFromConfig() {
		assertEquals(config.getString("should.not.exist"), null);
	}

}
