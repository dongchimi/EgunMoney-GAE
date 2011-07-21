package com.appspot.egun.money.comp.service;

import java.util.List;

import com.appspot.egun.money.comp.domain.Asset;

public interface AssetService {
	
	/**
	 * ���ο� �ڻ��� �����Ѵ�.
	 * @param userEmail		����� �̸���
	 * @return	���� ����
	 */
	public boolean createUserAsset(String userEmail);
	
	/** 
	 * ������� �ڻ� ��� ��ȸ
	 * @param	String 	userEmail	����� �̸���
	 */
	public List<Asset> getAssetsByUserEmail(String userEmail);
}
