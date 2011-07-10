package com.appspot.egun.money.comp.utility;

import java.util.List;

/**
 * Collection 관련 유틸리티
 * 
 * @author dklee
 * 
 */
public class CollectionU {
	/**
	 * List가 비었는지 확인
	 * 
	 * @param list
	 *            대상 List
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