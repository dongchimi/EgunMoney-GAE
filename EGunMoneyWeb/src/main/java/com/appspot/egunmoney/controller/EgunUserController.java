package com.appspot.egunmoney.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.Action;

/**
 * 사용자 Controller
 * @author dklee
 * @since	2010.09.14
 *
 */
@Component
@Scope("request")
public class EgunUserController {
	
	/** 로거 */
	private static final Logger logger = Logger.getLogger(EgunUserController.class.getName());
	
	/**
	 * 로그인화면 조회
	 */
	public String view() {
		logger.log(Level.FINE, "로그인 화면 조회");
		
		return Action.SUCCESS;
	}
	
	/**
	 * 로그인
	 */
	public String login() {
		
		String nextPage = "";
		logger.log(Level.FINE, "로그인");
		if (!loginSuccess()) {
			logger.log(Level.FINE, "로그인 실패");
			nextPage = "loginFail";
		} else {
			nextPage = Action.SUCCESS;
		}
		logger.log(Level.FINE, "로그인 성공");
		return nextPage;
	}
	private boolean loginSuccess() {
		logger.log(Level.FINE, "로그인이 가능한가?");
		return false;
	}
}
