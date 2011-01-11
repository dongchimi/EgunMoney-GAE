package com.appspot.egunmoney.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.appspot.egunmoney.domain.EgunUser;
import com.appspot.egunmoney.service.EgunUserService;
import com.appspot.egunmoney.utility.SessionManager;
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
	
	/** 사용자 */
	private EgunUser user;
	
	/** 에러 메시지*/
	private String errorMessage;
	
	public String viewUserInfo() {
		logger.log(Level.WARNING, user.getUserEmail());
		String email = user.getUserEmail();
		
		try {
			user = egunUserService.getUserByEmail(email);
		} catch (RuntimeException e) {
			errorMessage = e.getMessage();
		}
		
		logger.log(Level.WARNING, "데이터 가져옴");
		
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
		
		String inputEmail = user.getUserEmail();
		
		logger.log(Level.FINE, "로그인");
		if ( loginSuccess(inputEmail) ) {
			logger.log(Level.ALL, "로그인 성공");
			nextPage = Action.SUCCESS;
		} else {
			logger.log(Level.ALL, "로그인 실패");
			errorMessage = "존재하지 않는 아이디 입니다. 입력하신 아이디는 : " + inputEmail + "입니다."; 
			nextPage = "loginFail";
		}
		
		return nextPage;
	}
	
	private boolean loginSuccess(String inputEmail) {
		
		boolean login = false;
		
		EgunUser emailUser = egunUserService.getUserByEmail(inputEmail);
		if (emailUser != null) {
			String emailUserPassword = emailUser.getPassword();
			String inputPassword = user.getPassword(); 
			if (emailUserPassword.equals( inputPassword )) {
				login = true;
				
				// 로그인 성공 했으므로 로그인 정보를 세션에 담는다.
				// TODO 이동규 세션에 담는게 맞는가?
				SessionManager.putUser(emailUser);
			} else {
				login = false;
			}
		} else {
			login = false;
		}
		
		return login;
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
	public String getErrorMessage() {
		return errorMessage;
	}
}
