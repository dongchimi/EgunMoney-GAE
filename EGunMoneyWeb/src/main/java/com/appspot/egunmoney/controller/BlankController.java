package com.appspot.egunmoney.controller;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.Action;

/**
 * �� ȭ�� ��ȸ�� ���� Controller
 * @author dklee
 * @since 2010.09.15
 *
 */
@Component
public class BlankController {
	
	/** �α��� ȭ�� ��ȸ */
	public String loginView(){
		return Action.SUCCESS;
	}
	
	/** ȸ������ ȭ�� ��ȸ */
	public String joinView() {
		return Action.SUCCESS;
	}
}
