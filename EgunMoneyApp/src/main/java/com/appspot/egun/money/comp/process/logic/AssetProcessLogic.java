package com.appspot.egun.money.comp.process.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appspot.egun.money.comp.domain.asset.EgunUserAsset;
import com.appspot.egun.money.comp.process.AssetProcess;
import com.appspot.egun.money.comp.service.AssetService;
import com.appspot.egun.money.comp.service.FieldService;

@Component
public class AssetProcessLogic implements AssetProcess {
	
	@Autowired
	private AssetService assetService;
	
	@Autowired
	private FieldService fieldService;
	
	@Override
	public boolean registerDefaultUserAsset(String userEmail) {
		// �⺻�ڻ��� ���
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
}
