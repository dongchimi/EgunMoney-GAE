package com.appspot.egun.money.comp.utility;

/**
 * 이건머니 유틸리티
 * 
 * @author dongchimi
 * @since	2011.07.10
 */
public class EgunU {
	
	/**
	 * 토큰생성
	 * @param userEmail
	 * @param password
	 * @param nickName
	 * @return
	 */
	public static String generateAuthToken(String userEmail, String password, String nickName) {
		// TODO 이동규 토큰을 생성해야 함
		String token = userEmail + password;
		return token;
	}
}
