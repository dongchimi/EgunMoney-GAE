package com.appspot.egunmoney.utility;

import java.util.List;


/**
 * List ���� ��ƿ��Ƽ
 * @author dklee
 *
 */
public class CU {
	
	/**
	 * List�� ������� Ȯ��
	 * @param list ��� List
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