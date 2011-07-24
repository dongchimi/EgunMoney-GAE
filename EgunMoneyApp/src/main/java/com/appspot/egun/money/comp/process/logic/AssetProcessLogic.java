package com.appspot.egun.money.comp.process.logic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appspot.egun.money.comp.domain.Asset;
import com.appspot.egun.money.comp.domain.AssetType;
import com.appspot.egun.money.comp.domain.Field;
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
		// 기본자산타입을 등록
		List<AssetType> defaultAssetTypes = getDefaultAssetTypes(userEmail);
		for (AssetType defaultAssetType : defaultAssetTypes) {
			List<Field> fields = defaultAssetType.getFields();
			List<Long> fieldOids = fieldService.registerFields(fields);
			defaultAssetType.setFieldOids(fieldOids);
		}
		assetService.registerDefaultUserAssetTypes(defaultAssetTypes);
		
		// 기본자산을 등록
		assetService.registerDefaultUserAsset(defaultAssetTypes);
		
		return true;
	}
	
	
	
	private List<AssetType> getDefaultAssetTypes(String userEmail) {

		List<AssetType> defaultAssetTypes = new ArrayList<AssetType>();

		// 지갑
		AssetType wallet = new AssetType("지갑", userEmail);
		
		// 카드
		AssetType card = new AssetType("카드", userEmail);
		card.addField(new Field("카드명"));
		card.addField(new Field("카드번호"));
		card.addField(new Field("회사명"));

		// (일반)계좌
		AssetType bank = new AssetType("은행계좌", userEmail);
		bank.addField(new Field("은행명"));
		bank.addField(new Field("계좌번호"));
		
		// (대출)계좌
		AssetType loan = new AssetType("대출", userEmail);
		loan.addField(new Field("대출명"));
		loan.addField(new Field("은행명"));
		loan.addField(new Field("상환은행계좌번호"));
		loan.addField(new Field("상환일"));
		loan.addField(new Field("총상환액수"));
		loan.addField(new Field("남은액수"));
		loan.addField(new Field("매월이체금액"));
		
		// 보험
		AssetType insurance = new AssetType("보험", userEmail);
		insurance.addField(new Field("보험명"));
		insurance.addField(new Field("관련계좌번호"));
		insurance.addField(new Field("매월보험료"));
		insurance.addField(new Field("이체일"));
		
		// (적금)계좌
		AssetType installmentSaving = new AssetType("적금", userEmail);
		installmentSaving.addField(new Field("적금명"));
		installmentSaving.addField(new Field("은행명"));
		installmentSaving.addField(new Field("계좌번호"));
		installmentSaving.addField(new Field("이체금액"));
		installmentSaving.addField(new Field("이체일"));
		installmentSaving.addField(new Field("만기일"));

		defaultAssetTypes.add(wallet);
		defaultAssetTypes.add(card);
		defaultAssetTypes.add(bank);
		defaultAssetTypes.add(loan);
		defaultAssetTypes.add(insurance);
		defaultAssetTypes.add(installmentSaving);

		return defaultAssetTypes;
	}
	
	@Override
	public List<Asset> getAssetsByUserEmail(String userEmail) {
		return null;
	}
}
