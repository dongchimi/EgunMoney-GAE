package com.appspot.egun.money.comp.process;

import com.appspot.egun.money.comp.domain.asset.EgunUserAsset;

public interface AssetProcess {
	
	/**
	 * �⺻���� ���ο� �ڻ��� �����Ѵ�.
	 * @param userEmail		����� �̸���
	 * @return	���� ����
	 */
	public boolean registerDefaultUserAsset(String userEmail);
	
	/** 
	 * ������� �ڻ� ��� ��ȸ
	 * @param	String 	userEmail	����� �̸���
	 */
	public EgunUserAsset getAssetsByUserEmail(String userEmail);
}
