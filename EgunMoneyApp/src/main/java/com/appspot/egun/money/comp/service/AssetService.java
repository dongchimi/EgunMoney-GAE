package com.appspot.egun.money.comp.service;

import java.util.List;

import com.appspot.egun.money.comp.domain.Asset;
import com.appspot.egun.money.comp.domain.AssetType;

public interface AssetService {
	/**
	 * ���ο� �ڻ����¸� �����Ѵ�.
	 * @param assetTypes	�ڻ�����
	 * @return
	 */
	public long registerDefaultUserAssetTypes(List<AssetType> assetTypes);
	
	/**
	 * ���ο� �ڻ��� �����Ѵ�.
	 * @param assetType		����� �̸���
	 * @return	���� ����
	 */
	public boolean registerDefaultUserAsset(List<AssetType> defaultAssetType);
	
	/** 
	 * ������� �ڻ� ��� ��ȸ
	 * @param	String 	userEmail	����� �̸���
	 */
	public List<Asset> getAssetsByUserEmail(String userEmail);
}
