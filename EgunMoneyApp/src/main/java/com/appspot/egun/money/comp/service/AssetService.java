package com.appspot.egun.money.comp.service;

import com.appspot.egun.money.comp.domain.asset.EgunUserAsset;

public interface AssetService {
	
	/**
	 * ���ο� �ڻ��� �����Ѵ�.
	 * @param assetType		����� �̸���s
	 * @return	���� ����
	 */
	public long registerUserAsset(EgunUserAsset userAsset);
	
	/** 
	 * ������� �ڻ� ��� ��ȸ
	 * @param	String 	userEmail	����� �̸���
	 */
	public EgunUserAsset getUserAssetsByUserEmail(String userEmail);
}
