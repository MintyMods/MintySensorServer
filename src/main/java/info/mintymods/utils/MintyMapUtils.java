package info.mintymods.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import info.mintymods.repository.entities.MenuLine;

public class MintyMapUtils {

	public static <K, V> Map<K, V> toMap(Map.Entry<K, V>[] array) {
		if (array == null) { return null; }
		final Map<K, V> map = new HashMap<K, V>((int) (array.length * 1.5));
		for (final Entry<K, V> entry : array) {
			map.put(entry.getKey(), entry.getValue());
		}
		return map;
	}

	public static Map<Integer, MenuLine> toMap(MenuLine[] menu_lines) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public static <K, V> Map<K, V> toMap(Object[][] array) {
		if (array == null) { return null; }
		final Map<K, V> map = new HashMap<K, V>((int) (array.length * 1.5));
		for (final Object[] entry : array) {
			map.put((K) entry[0], (V) entry[1]);
		}
		return map;
	}
}
