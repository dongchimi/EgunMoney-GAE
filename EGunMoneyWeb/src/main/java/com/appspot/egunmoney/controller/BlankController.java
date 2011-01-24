package com.appspot.egunmoney.controller;

import org.springframework.stereotype.Component;

/**
 * 빈 화면 조회를 위한 Controller
 * @author dklee
 * @since 2010.09.15
 *
 */
@Component
public class BlankController {
	
	/** 로그인 화면 조회 */
	public String loginView(){
		return "";
	}
	
	/** 회원가입 화면 조회 */
	public String joinView() {
		return "";
	}
}
