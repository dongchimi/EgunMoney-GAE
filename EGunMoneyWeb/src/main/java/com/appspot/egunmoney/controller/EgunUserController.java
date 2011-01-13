package com.appspot.egunmoney.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.appspot.egunmoney.domain.EgunAccountBook;
import com.appspot.egunmoney.domain.EgunUser;
import com.appspot.egunmoney.service.EgunAccountBookService;
import com.appspot.egunmoney.service.EgunUserService;
import com.appspot.egunmoney.utility.SessionManager;
import com.google.appengine.api.datastore.Key;
import com.opensymphony.xwork2.Action;
 
/**
 * ����� Controller
 * @author dklee
 * @since	2010.09.14
 */
@Component
@Scope("request")
public class EgunUserController {
	
	/** �ΰ� */
	private static final Logger logger = Logger.getLogger(EgunUserController.class.getSimpleName());
	
	@Autowired
	private EgunUserService egunUserService;
	
	@Autowired
	private EgunAccountBookService egunAccountBookService;
	
	/** ����� */
	private EgunUser user;
	
	/** ���� �޽���*/
	private String errorMessage;
	
	public String viewUserInfo() {
		String email = user.getUserEmail();
		
		try {
			user = egunUserService.getUserByEmail(email);
		} catch (RuntimeException e) {
			errorMessage = e.getMessage();
		}
		
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
				// TODO �̵��� ���ǿ� ��°� �´°�? �ٸ� ����� ������?
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
		Key oid = egunUserService.registerUser(user);
		if (oid != null) {
			user.setOid(oid);
			
			// �α��� ���� �����Ƿ� �α��� ������ ���ǿ� ��´�.
			// TODO �̵��� ���ǿ� ��°� �´°�? �ٸ� ����� ������?
			SessionManager.putUser(user);
			
			// ����� ����
			EgunAccountBook accountBook = new EgunAccountBook( user );
			egunAccountBookService.createEgunAccountBook(accountBook);
			
		} else {
			// TODO �̵��� �������� ��� ����̵�
		}
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
