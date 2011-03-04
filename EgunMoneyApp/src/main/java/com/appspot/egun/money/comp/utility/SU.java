package com.appspot.egun.money.comp.utility;

/**
 * String 유틸리티
 * @author 이동규
 * @since 2010.11.27
 */
public class SU {
	/**
	 * 문자열이 Null 또는 공백문자인지 여부 조회
	 * @param target 문자열
	 * @return 문자열이 Null 또는 공백문자인지 여부`
	 */
	public static boolean isEmptyOrNull(String target) {
		return target == null || target.trim().length() < 1;
	}
}
