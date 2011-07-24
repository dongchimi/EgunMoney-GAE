package com.appspot.egun.money.comp.process;

import java.util.List;

import com.appspot.egun.money.comp.domain.Asset;

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
	public List<Asset> getAssetsByUserEmail(String userEmail);
}
