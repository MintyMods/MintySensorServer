package info.mintymods.utils;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;

public class ProfillerUtils {

	public static String getGarbageCollectionStats() {
		long collections = 0;
		long totalTime = 0;
		for (final GarbageCollectorMXBean gc : ManagementFactory.getGarbageCollectorMXBeans()) {
			final long count = gc.getCollectionCount();
			if (count >= 0) {
				collections += count;
			}
			final long time = gc.getCollectionTime();
			if (time >= 0) {
				totalTime += time;
			}
		}
		return "Garbage Collections: " + collections + " : " + totalTime + " (ms)";
	}
}
