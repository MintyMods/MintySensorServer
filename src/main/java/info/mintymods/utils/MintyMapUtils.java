package info.mintymods.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MintyMapUtils {

	public static <K, V> Map<K, V> toMap(final Map.Entry<K, V>[] array) {
		if (array == null) {
			return null;
		}
		final Map<K, V> map = new HashMap<>((int) (array.length * 1.5));
		for (final Entry<K, V> entry : array) {
			map.put(entry.getKey(), entry.getValue());
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public static <K, V> Map<K, V> toMap(final Object[][] array) {
		if (array == null) {
			return null;
		}
		final Map<K, V> map = new HashMap<>((int) (array.length * 1.5));
		for (final Object[] entry : array) {
			map.put((K) entry[0], (V) entry[1]);
		}
		return map;
	}
}
