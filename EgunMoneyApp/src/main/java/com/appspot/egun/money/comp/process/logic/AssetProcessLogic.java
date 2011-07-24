package com.appspot.egun.money.comp.process.logic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appspot.egun.money.comp.domain.asset.AbstractAssetType;
import com.appspot.egun.money.comp.domain.asset.EgunUserAsset;
import com.appspot.egun.money.comp.domain.asset.WalletAssetType;
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
		List<AbstractAssetType> defaultAssetTypes = getDefaultAssetTypes();
		
		// 자산타입 등록
		assetService.registerUserAssetTypes(defaultAssetTypes);
		
		// 기본자산을 등록
		EgunUserAsset userAsset = new EgunUserAsset(userEmail);
		for (AbstractAssetType type : defaultAssetTypes) {
			userAsset.addAssetOid(type.getOid());
		}
		assetService.registerUserAsset(userAsset);
		
		// 기본자산타입을 등록
//		List<AssetType> defaultAssetTypes = getDefaultAssetTypes(userEmail);
//		for (AssetType defaultAssetType : defaultAssetTypes) {
//			List<Field> fields = defaultAssetType.getFields();
//			List<Long> fieldOids = fieldService.registerFields(fields);
//			defaultAssetType.setFieldOids(fieldOids);
//		}
//		assetService.registerDefaultUserAssetTypes(defaultAssetTypes);
		
		return true;
	}
	
	private List<AbstractAssetType> getDefaultAssetTypes() {
		
		List<AbstractAssetType> defaults = new ArrayList<AbstractAssetType>();
		WalletAssetType wallet = new WalletAssetType("내지갑");
		
		defaults.add(wallet);
		
		return defaults;
	}
	
	@Override
	public List<EgunUserAsset> getAssetsByUserEmail(String userEmail) {
		return null;
	}
}
