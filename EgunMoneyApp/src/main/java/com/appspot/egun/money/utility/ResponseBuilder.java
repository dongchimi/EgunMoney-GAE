package com.appspot.egun.money.utility;

public class ResponseBuilder {

	public static Response buildSuccessResponse(Object obj) {
		Response res = new Response( Response.STATUS_SUCCESS );
		res.setResObj(obj);
		return res;
	}
	
	public static Response buildEmptyResponse(String message) {
		Response res = new Response( Response.STATUS_FAIL );
		res.setMessage1(message);
		return res;
	}
}
