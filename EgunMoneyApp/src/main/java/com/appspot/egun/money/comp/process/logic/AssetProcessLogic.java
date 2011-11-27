package com.appspot.egun.money.comp.process.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appspot.egun.money.comp.domain.asset.Asset;
import com.appspot.egun.money.comp.domain.asset.AssetType;
import com.appspot.egun.money.comp.domain.asset.BankAsset;
import com.appspot.egun.money.comp.domain.asset.EgunUserAsset;
import com.appspot.egun.money.comp.process.AssetProcess;
import com.appspot.egun.money.comp.service.AssetService;

@Component
public class AssetProcessLogic implements AssetProcess {
	
	@Autowired
	private AssetService assetService;
	
//	@Autowired
//	private FieldService fieldService;
//	
	@Override
	public boolean registerDefaultUserAsset(String userEmail) {
		// 기본자산을 등록
		EgunUserAsset userAsset = new EgunUserAsset(userEmail);
		assetService.registerUserAsset(userAsset);
		
		return true;
	}
	
	@Override
	public EgunUserAsset getAssetsByUserEmail(String userEmail) {
		EgunUserAsset userAsset = assetService.getUserAssetsByUserEmail(userEmail);
		if (userAsset != null) {
			userAsset.buildForUI();
		}
		return userAsset;
	}

	@Override
	public void registerAsset(String assetType, String assetName, String userEmail) {
		
		EgunUserAsset userAsset = assetService.getUserAssetsByUserEmail(userEmail);
		if(userAsset == null) {
			throw new RuntimeException("자산이 없습니다.");
		}
		
		Asset asset = null;
		AssetType type = AssetType.valueOf(assetType);
		if(type == AssetType.BANK) {
			asset = new BankAsset();
		}
		else if (type == AssetType.CREDITCARD) {
			
		}
		else if (type == AssetType.INSURANCE) {
			
		}
	}
}
