package com.appspot.egun.money.comp.service;

import java.util.List;

import com.appspot.egun.money.comp.domain.asset.AbstractAssetType;
import com.appspot.egun.money.comp.domain.asset.EgunUserAsset;

public interface AssetService {
	
	/**
	 * �ڻ��� ����Ѵ�.
	 * @param assetTypes	�ڻ�����
	 * @return
	 */
	public long registerUserAssetTypes(List<AbstractAssetType> assetTypes);
	
	/**
	 * ���ο� �ڻ��� �����Ѵ�.
	 * @param assetType		����� �̸���
	 * @return	���� ����
	 */
	public long registerUserAsset(EgunUserAsset userAsset);
	
	/** 
	 * ������� �ڻ� ��� ��ȸ
	 * @param	String 	userEmail	����� �̸���
	 */
	public EgunUserAsset getUserAssetsByUserEmail(String userEmail);
}
