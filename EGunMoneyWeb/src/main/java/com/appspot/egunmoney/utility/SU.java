package com.appspot.egunmoney.utility;

/**
 * String ��ƿ��Ƽ
 * @author �̵���
 * @since 2010.11.27
 */
public class SU {
	/**
	 * ���ڿ��� Null �Ǵ� ���鹮������ ���� ��ȸ
	 * @param target ���ڿ�
	 * @return ���ڿ��� Null �Ǵ� ���鹮������ ����`
	 */
	public static boolean isEmptyAndNull(String target) {
		return target == null || target.trim().length() < 1;
	}
}
