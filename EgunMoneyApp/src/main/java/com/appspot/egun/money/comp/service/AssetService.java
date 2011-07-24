package com.appspot.egun.money.comp.service;

import java.util.List;

import com.appspot.egun.money.comp.domain.Asset;
import com.appspot.egun.money.comp.domain.AssetType;

public interface AssetService {
	/**
	 * 새로운 자산형태를 생성한다.
	 * @param assetTypes	자산형태
	 * @return
	 */
	public long registerDefaultUserAssetTypes(List<AssetType> assetTypes);
	
	/**
	 * 새로운 자산을 생성한다.
	 * @param assetType		사용자 이메일
	 * @return	생성 여부
	 */
	public boolean registerDefaultUserAsset(List<AssetType> defaultAssetType);
	
	/** 
	 * 사용자의 자산 목록 조회
	 * @param	String 	userEmail	사용자 이메일
	 */
	public List<Asset> getAssetsByUserEmail(String userEmail);
}
