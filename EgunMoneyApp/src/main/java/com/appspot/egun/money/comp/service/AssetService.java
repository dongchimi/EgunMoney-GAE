package com.appspot.egun.money.comp.service;

import java.util.List;

import com.appspot.egun.money.comp.domain.asset.AbstractAssetType;
import com.appspot.egun.money.comp.domain.asset.EgunUserAsset;

public interface AssetService {
	
	/**
	 * 자산을 등록한다.
	 * @param assetTypes	자산형태
	 * @return
	 */
	public long registerUserAssetTypes(List<AbstractAssetType> assetTypes);
	
	/**
	 * 새로운 자산을 생성한다.
	 * @param assetType		사용자 이메일
	 * @return	생성 여부
	 */
	public long registerUserAsset(EgunUserAsset userAsset);
	
	/** 
	 * 사용자의 자산 목록 조회
	 * @param	String 	userEmail	사용자 이메일
	 */
	public EgunUserAsset getUserAssetsByUserEmail(String userEmail);
}
