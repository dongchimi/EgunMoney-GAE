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
 * ����� Controller
 * @author dklee
 * @since	2010.09.14
 *
 */
@Component
@Scope("request")
public class EgunUserController {
	
	/** �ΰ� */
	private static final Logger logger = Logger.getLogger(EgunUserController.class.getSimpleName());
	
	@Autowired
	private EgunUserService egunUserService;
	
	/** ����� */
	private EgunUser user;
	
	/** ���� �޽���*/
	private String errorMessage;
	
	public String viewUserInfo() {
		logger.log(Level.WARNING, user.getUserEmail());
		String email = user.getUserEmail();
		
		try {
			user = egunUserService.getUserByEmail(email);
		} catch (RuntimeException e) {
			errorMessage = e.getMessage();
		}
		
		logger.log(Level.WARNING, "������ ������");
		
		return Action.SUCCESS;
	}
	/**
	 * �α���ȭ�� ��ȸ
	 */
	public String view() {
		logger.log(Level.FINE, "�α��� ȭ�� ��ȸ");
		return Action.SUCCESS;
	}
	
	/**
	 * �α���
	 */
	public String login() {
		String nextPage = "";
		
		String inputEmail = user.getUserEmail();
		
		logger.log(Level.FINE, "�α���");
		if ( loginSuccess(inputEmail) ) {
			logger.log(Level.ALL, "�α��� ����");
			nextPage = Action.SUCCESS;
		} else {
			logger.log(Level.ALL, "�α��� ����");
			errorMessage = "�������� �ʴ� ���̵� �Դϴ�. �Է��Ͻ� ���̵�� : " + inputEmail + "�Դϴ�."; 
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
				
				// �α��� ���� �����Ƿ� �α��� ������ ���ǿ� ��´�.
				// TODO �̵��� ���ǿ� ��°� �´°�?
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
	 * ȸ������
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
