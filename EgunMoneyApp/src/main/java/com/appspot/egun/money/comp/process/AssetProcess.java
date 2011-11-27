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
	
	/**
	 * ���ο� �ڻ��� ����Ѵ�.
	 * @param assetType	�ڻ�Ÿ��	
	 * @param assetName	�ڻ��
	 * @param userEmail	�ڻ� ���� ID(�̸���)
	 */
	public void registerAsset(String assetType, String assetName, String userEmail);
}
