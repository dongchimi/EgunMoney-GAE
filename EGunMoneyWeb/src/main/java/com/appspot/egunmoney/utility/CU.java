package com.appspot.egunmoney.utility;

import java.util.List;


/**
 * List 관련 유틸리티
 * @author dklee
 *
 */
public class CU {
	
	/**
	 * List가 비었는지 확인
	 * @param list 대상 List
	 * @return 비었는지 여부
	 */
	public static boolean isEmpty(List<?> list) {
		if (list == null || list.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}