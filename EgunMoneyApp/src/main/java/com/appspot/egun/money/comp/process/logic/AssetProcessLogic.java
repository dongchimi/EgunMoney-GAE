package com.appspot.egun.money.comp.process.logic;

import java.util.List;

import org.springframework.stereotype.Component;

import com.appspot.egun.money.comp.domain.Asset;
import com.appspot.egun.money.comp.process.AssetProcess;

@Component
public class AssetProcessLogic implements AssetProcess {

	@Override
	public boolean createNewAssetOfEgunUser(String userEmail) {
		
		return false;
	}

	@Override
	public List<Asset> getAssetsByUserEmail(String userEmail) {
		return null;
	}
}
