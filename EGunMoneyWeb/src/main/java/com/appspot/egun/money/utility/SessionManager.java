package com.appspot.egun.money.utility;

import javax.servlet.http.HttpServletRequest;

import com.appspot.egun.money.domain.EgunUser;

public class SessionManager {
	
	/** �α��� ����� */
	public static final String LOGIN_USER = "loginUser";

	public static EgunUser getLoginUser(HttpServletRequest request) {
		return (EgunUser) request.getSession().getAttribute(LOGIN_USER);
	}

	public static void setLoginUser(HttpServletRequest request, EgunUser egunUser) {
		request.getSession().setAttribute(LOGIN_USER, egunUser);
	}
}
