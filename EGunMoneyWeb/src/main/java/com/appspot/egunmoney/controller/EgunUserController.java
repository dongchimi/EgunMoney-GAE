package com.appspot.egunmoney.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

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
	private static final Logger logger = Logger.getLogger(EgunUserController.class.getName());
	
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
		logger.log(Level.FINE, "�α���");
		if (!loginSuccess()) {
			logger.log(Level.FINE, "�α��� ����");
			nextPage = "loginFail";
		} else {
			nextPage = Action.SUCCESS;
		}
		logger.log(Level.FINE, "�α��� ����");
		return nextPage;
	}
	private boolean loginSuccess() {
		logger.log(Level.FINE, "�α����� �����Ѱ�?");
		return false;
	}
}
