package com.appspot.egun.money.comp.utility;

import javax.servlet.http.HttpServletRequest;

import com.appspot.egun.money.comp.domain.EgunUser;

public class SessionManager {
	
	/** 로그인 사용자 */
	public static final String LOGIN_USER = "loginUser";

	public static EgunUser getLoginUser(HttpServletRequest request) {
		return (EgunUser) request.getSession().getAttribute(LOGIN_USER);
	}

	public static void setLoginUser(HttpServletRequest request, EgunUser egunUser) {
		request.getSession().setAttribute(LOGIN_USER, egunUser);
	}
}
