package com.appspot.egun.money.comp.utility;

/**
 * �̰ǸӴ� ��ƿ��Ƽ
 * 
 * @author dongchimi
 * @since	2011.07.10
 */
public class EgunU {
	
	/**
	 * ��ū����
	 * @param userEmail
	 * @param password
	 * @param nickName
	 * @return
	 */
	public static String generateAuthToken(String userEmail, String password, String nickName) {
		// TODO �̵��� ��ū�� �����ؾ� ��
		String token = userEmail + password;
		return token;
	}
}
