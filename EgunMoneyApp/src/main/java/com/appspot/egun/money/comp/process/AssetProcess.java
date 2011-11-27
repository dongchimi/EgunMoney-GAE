package com.appspot.egun.money.comp.process;

import com.appspot.egun.money.comp.domain.asset.EgunUserAsset;

public interface AssetProcess {
	
	/**
	 * 기본적인 새로운 자산을 생성한다.
	 * @param userEmail		사용자 이메일
	 * @return	생성 여부
	 */
	public boolean registerDefaultUserAsset(String userEmail);
	
	/** 
	 * 사용자의 자산 목록 조회
	 * @param	String 	userEmail	사용자 이메일
	 */
	public EgunUserAsset getAssetsByUserEmail(String userEmail);
	
	/**
	 * 새로운 자산을 등록한다.
	 * @param assetType	자산타입	
	 * @param assetName	자산명
	 * @param userEmail	자산 주인 ID(이메일)
	 */
	public void registerAsset(String assetType, String assetName, String userEmail);
}
