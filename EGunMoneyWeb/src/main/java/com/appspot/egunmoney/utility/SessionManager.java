package com.appspot.egunmoney.utility;

import java.util.Map;

import com.appspot.egunmoney.domain.EgunUser;

public class SessionManager {
	
	private static String userKey = "USER_KEY";
	
	private static Map<String, Object> sessionMap = null;

	public static void newInstance( Map<String, Object> sessionMap ) {
		SessionManager.sessionMap = sessionMap;
	}
	
	public static void putUser(EgunUser user) {
		sessionMap.put(userKey, user);
	}
	
	public static EgunUser getUser() {
		return (EgunUser) sessionMap.get(userKey);
	}
}
