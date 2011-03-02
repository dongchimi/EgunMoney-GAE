package com.appspot.egun.money.comp.utility;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.appspot.egun.money.comp.utility.json.DateJsonValuerocessor;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JSONBodyWriter implements MessageBodyWriter<Object> {

	private JsonConfig jsonConfig;

	public JSONBodyWriter() {
		this.jsonConfig = new JsonConfig();
		this.jsonConfig.registerJsonValueProcessor(java.util.Date.class,
				new DateJsonValuerocessor());
	}

	@Override
	public boolean isWriteable(Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType) {
		return true;
	}

	@Override
	public long getSize(Object t, Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType) {
		return -1;
	}

	@Override
	public void writeTo(Object object, Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders,
			OutputStream entityStream) throws IOException,
			WebApplicationException {
		
		String result;
		if (object == null) {
			result = "";
		} else if (object instanceof String) {
			result = (String) object;
		} else if (object instanceof JSONObject) {
			result = ((JSONObject) object).toString();
		} else if (object instanceof List) {
			result = (JSONArray.fromObject(object, jsonConfig)).toString();
		} else if (object.getClass().isArray()) {
			result = (JSONArray.fromObject(object, jsonConfig)).toString();
		} else {
			result = (JSONArray.fromObject(object, jsonConfig)).toString();
		}
		
		entityStream.write(result.getBytes("UTF-8"));
	}
}
