package com.appspot.egun.money.utility;

public class ResponseBuilder {

	public static JSONResponse buildFailResponse(Exception obj) {
		JSONResponse res = new JSONResponse( JSONResponse.STATUS_FAIL );
		res.setMessage1(obj.getMessage());
		return res;
	}
	public static JSONResponse buildSuccessResponse(Object obj) {
		JSONResponse res = new JSONResponse( JSONResponse.STATUS_SUCCESS );
		res.setResObj(obj);
		return res;
	}
	
	public static JSONResponse buildEmptyResponse(String message) {
		JSONResponse res = new JSONResponse( JSONResponse.STATUS_FAIL );
		res.setMessage1(message);
		return res;
	}
}
