package com.appspot.egun.money.comp.service.logic;

import java.util.ArrayList;
import java.util.List;

import com.appspot.egun.money.comp.domain.Asset;
import com.appspot.egun.money.comp.domain.AssetType;
import com.appspot.egun.money.comp.service.AssetService;

public class AssetServiceLogic implements AssetService {

	@Override
	public boolean createUserAsset(String userEmail) {
		// 기본 자산형태를 만든다.
		List<AssetType> defaultAssetTypes = getDefaultAssetTypes(userEmail);
		
		// 사용자의 자산에 등록한다.
		
		return false;
	}

	@Override
	public List<Asset> getAssetsByUserEmail(String userEmail) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private List<AssetType> getDefaultAssetTypes(String userEmail) {
		
		List<AssetType> defaultAssetTypes = new ArrayList<AssetType>();
		
		// 지갑
		AssetType wallet = new AssetType("지갑", userEmail);
		// 카드
		AssetType card = new AssetType("카드", userEmail);
		// (일반)계좌
		AssetType bank = new AssetType("은행계좌", userEmail);
		// (대출)계좌
		AssetType loan = new AssetType("대출", userEmail);
		// 보험
		AssetType insurance = new AssetType("보험", userEmail);
		// (적금)계좌
		AssetType installmentSaving = new AssetType("적금", userEmail);
		
		defaultAssetTypes.add(wallet);
		defaultAssetTypes.add(card);
		defaultAssetTypes.add(bank);
		defaultAssetTypes.add(loan);
		defaultAssetTypes.add(insurance);
		defaultAssetTypes.add(installmentSaving);
		
		return defaultAssetTypes;
	}
}
