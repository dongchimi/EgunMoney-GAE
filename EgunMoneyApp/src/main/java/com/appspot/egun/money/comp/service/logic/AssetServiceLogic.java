package com.appspot.egun.money.comp.service.logic;

import java.util.ArrayList;
import java.util.List;

import com.appspot.egun.money.comp.domain.Asset;
import com.appspot.egun.money.comp.domain.AssetType;
import com.appspot.egun.money.comp.service.AssetService;

public class AssetServiceLogic implements AssetService {

	@Override
	public boolean createUserAsset(String userEmail) {
		// �⺻ �ڻ����¸� �����.
		List<AssetType> defaultAssetTypes = getDefaultAssetTypes(userEmail);
		
		// ������� �ڻ꿡 ����Ѵ�.
		
		return false;
	}

	@Override
	public List<Asset> getAssetsByUserEmail(String userEmail) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private List<AssetType> getDefaultAssetTypes(String userEmail) {
		
		List<AssetType> defaultAssetTypes = new ArrayList<AssetType>();
		
		// ����
		AssetType wallet = new AssetType("����", userEmail);
		// ī��
		AssetType card = new AssetType("ī��", userEmail);
		// (�Ϲ�)����
		AssetType bank = new AssetType("�������", userEmail);
		// (����)����
		AssetType loan = new AssetType("����", userEmail);
		// ����
		AssetType insurance = new AssetType("����", userEmail);
		// (����)����
		AssetType installmentSaving = new AssetType("����", userEmail);
		
		defaultAssetTypes.add(wallet);
		defaultAssetTypes.add(card);
		defaultAssetTypes.add(bank);
		defaultAssetTypes.add(loan);
		defaultAssetTypes.add(insurance);
		defaultAssetTypes.add(installmentSaving);
		
		return defaultAssetTypes;
	}
}
