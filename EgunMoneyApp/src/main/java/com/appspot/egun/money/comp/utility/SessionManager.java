package com.appspot.egun.money.comp.utility;

import javax.servlet.http.HttpServletRequest;

import com.appspot.egun.money.comp.domain.EgunUser;

public class SessionManager {
	
	/** 로그인 사용자 */
	public static final String LOGIN_USER = "loginUser";
	/** 선택한 가계부 */
	public static final String CURRENT_ACCOUNT_BOOK_ID = "currentAccountBookId";

	public static EgunUser getLoginUser(HttpServletRequest request) {
		return (EgunUser) request.getSession().getAttribute(LOGIN_USER);
	}
	
	public static String getLoginUserEmail(HttpServletRequest request) {
		EgunUser user = getLoginUser(request);
		if (user == null) return null; 
		
		return user.getUserEmail();
	}
	
	public static boolean isLogin(HttpServletRequest request) {
		EgunUser user = getLoginUser(request);
		if (user == null) return false;
		
		return true;
	}

	public static void setLoginUser(HttpServletRequest request, EgunUser egunUser) {
		request.getSession().setAttribute(LOGIN_USER, egunUser);
	}
	
	public static void setAccountBookId(HttpServletRequest request, Long bookId) {
		request.getSession().setAttribute(CURRENT_ACCOUNT_BOOK_ID, bookId);
	}
	
	public static long getCurrentAccountBookId(HttpServletRequest request) {
		Long bookId = (Long) request.getSession().getAttribute(CURRENT_ACCOUNT_BOOK_ID);
		if (bookId == null) {
			bookId = new Long(-1);
		}
		return bookId;
	}
}
