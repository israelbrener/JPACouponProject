package com.eitan.couponsproject.cache;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;

@Controller
public class ChacheController implements ICacheController{

	// This class serves as a basis for a clustered cache mechanism
	private Map<String, Object> cacheMap;

	public ChacheController() {
		this.cacheMap = new HashMap<String, Object>();
	}

	public Object get(String key) {
		return this.cacheMap.get(key);
	}

	public void put(String key, Object value) {
		this.cacheMap.put(key, value);
	}
	

}
