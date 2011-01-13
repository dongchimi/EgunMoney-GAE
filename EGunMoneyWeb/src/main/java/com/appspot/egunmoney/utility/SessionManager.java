package com.appspot.egunmoney.utility;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.appspot.egunmoney.domain.EgunUser;

public class SessionManager {
	
	private static String userKey = "USER_KEY";
	
	private static HttpSession session = null;

	private static void newInstance() {
		if (session == null) {
			session = ServletActionContext.getRequest().getSession();
		}
	}
	
	public static void putUser(EgunUser user) {
		if (session == null) {
			SessionManager.newInstance();
		}
		session.setAttribute(userKey, user);
	}
	
	public static EgunUser getUser() {
		return (EgunUser) session.getAttribute(userKey);
	}
}
