package com.appspot.egun.money.comp.utility;

import java.util.List;

/**
 * Collection ���� ��ƿ��Ƽ
 * 
 * @author dklee
 * 
 */
public class CollectionU {
	/**
	 * List�� ������� Ȯ��
	 * 
	 * @param list
	 *            ��� List
	 * @return ������� ����
	 */
	public static boolean isEmpty(List<?> list) {
		if (list == null || list.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}