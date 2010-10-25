package com.appspot.egunmoney.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.appspot.egunmoney.domain.EgunUser;
import com.appspot.egunmoney.service.EgunUserService;
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
	private static final Logger logger = Logger.getLogger(EgunUserController.class.getSimpleName());
	
	@Autowired
	private EgunUserService egunUserService;
	
	/* 사용자 */
	private EgunUser user;
	
	public String viewUserInfo() {
		logger.log(Level.WARNING, user.getUserEmail());
		String email = user.getUserEmail();
		user = egunUserService.getUserInfo(email);
		
		logger.log(Level.WARNING, "데이터 가져옴");
		logger.log(Level.WARNING, user.getUserEmail());
		logger.log(Level.WARNING, user.getPassword());
		logger.log(Level.WARNING, user.getNickName());
		
		return Action.SUCCESS;
	}
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
	
	/**
	 * 회원가입
	 * @return
	 */
	public String join() {
		logger.log(Level.WARNING, user.getUserEmail());
		logger.log(Level.WARNING, user.getPassword());
		logger.log(Level.WARNING, user.getNickName());
		
		long userOid = egunUserService.registerUser(user);
		logger.log(Level.WARNING, "userOid : " + userOid);
		return Action.SUCCESS;
	}

	public EgunUser getUser() {
		return user;
	}

	public void setUser(EgunUser user) {
		this.user = user;
	}
}
