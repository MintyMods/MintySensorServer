package info.mintymods.utils;

import info.mintymods.msm.MsmSensorReading;
import info.mintymods.msm.MsmSensorType;

public class IconResolver {

	public static String resolve(final MsmSensorReading reading) {
		return resolveByType(reading.getType(), reading.getLabel().getName());
	}

	private static String resolveByType(final MsmSensorType type, final String name) {
		switch (type) {
			case CLOCK :
				return resolveClock(name);
			case CURRENT :
				return resolveCurrent(name);
			case FAN :
				return resolveFan(name);
			case POWER :
				return resolvePower(name);
			case USAGE :
				return resolveUsage(name);
			case TEMP :
				return resolveTemp(name);
			case OTHER :
				return resolveOther(name);
			case VOLT :
				return resolveVolt(name);
			case NONE :
				return resolveNone(name);
		}
		return "";
	}

	private static String resolveOther(final String name) {
		return "";
	}

	private static String resolveVolt(final String name) {
		return "";
	}

	private static String resolveNone(final String name) {
		return "";
	}

	private static String resolveTemp(final String name) {
		return "";
	}

	private static String resolveUsage(final String name) {
		return "";
	}

	private static String resolvePower(final String name) {
		return "";
	}

	private static String resolveFan(final String name) {
		return "";
	}

	private static String resolveCurrent(final String name) {
		return "";
	}

	private static String resolveClock(final String name) {
		return "";
	}
}
