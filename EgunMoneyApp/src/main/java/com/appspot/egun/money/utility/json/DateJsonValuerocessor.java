package com.appspot.egun.money.utility.json;

import java.util.Date;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import com.appspot.egun.money.utility.DU;

public class DateJsonValuerocessor implements JsonValueProcessor {

	@Override
	public Object processArrayValue(Object value, JsonConfig jsonConfig) {
		return process( value, jsonConfig);
	}

	@Override
	public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
		return process (value, jsonConfig);
	}
	
	private Object process(Object value, JsonConfig jsonConfig) {
		if ( !(value instanceof Date)) return null;
		
		return DU.convertFormat((Date) value);
	}
}
