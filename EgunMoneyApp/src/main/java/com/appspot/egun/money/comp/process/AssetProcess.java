package com.appspot.egun.money.comp.process;

import java.util.List;

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
	public List<EgunUserAsset> getAssetsByUserEmail(String userEmail);
}
