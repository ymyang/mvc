package com.qycloud.oatos.mvc;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 数据缓存
 * 
 * @author yang
 * 
 */
public final class Registry {

	private static ConcurrentMap<Object, Object> map = new ConcurrentHashMap<Object, Object>();

	private Registry() {
	}

	@SuppressWarnings("unchecked")
	public static <T> T get(Object key) {
		return (T) map.get(key);
	}

	public static void put(Object key, Object obj) {
		map.put(key, obj);
	}

	public static void clear(Object key) {
		map.remove(key);
	}

	public static void clear() {
		map.clear();
	}

}
