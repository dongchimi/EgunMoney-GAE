package com.appspot.egun.money.utility.json;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class JSONResponseValueProcessor implements JsonValueProcessor {

	@Override
	public Object processArrayValue(Object value, JsonConfig jsonConfig) {
		return process( value, jsonConfig);
	}

	@Override
	public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
		return process (value, jsonConfig);
	}
	
	private Object process(Object value, JsonConfig jsonConfig) {
		
		return JSONObject.fromObject( JSONSerializer.toJSON(value));
	}
}
