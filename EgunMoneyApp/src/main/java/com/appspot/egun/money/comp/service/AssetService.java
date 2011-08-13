package com.appspot.egun.money.comp.service;

import com.appspot.egun.money.comp.domain.asset.EgunUserAsset;

public interface AssetService {
	
	/**
	 * 새로운 자산을 생성한다.
	 * @param assetType		사용자 이메일s
	 * @return	생성 여부
	 */
	public long registerUserAsset(EgunUserAsset userAsset);
	
	/** 
	 * 사용자의 자산 목록 조회
	 * @param	String 	userEmail	사용자 이메일
	 */
	public EgunUserAsset getUserAssetsByUserEmail(String userEmail);
}
