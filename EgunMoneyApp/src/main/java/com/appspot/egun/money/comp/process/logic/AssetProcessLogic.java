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
		// �⺻�ڻ�Ÿ���� ���
		List<AssetType> defaultAssetTypes = getDefaultAssetTypes(userEmail);
		for (AssetType defaultAssetType : defaultAssetTypes) {
			List<Field> fields = defaultAssetType.getFields();
			List<Long> fieldOids = fieldService.registerFields(fields);
			defaultAssetType.setFieldOids(fieldOids);
		}
		assetService.registerDefaultUserAssetTypes(defaultAssetTypes);
		
		// �⺻�ڻ��� ���
		assetService.registerDefaultUserAsset(defaultAssetTypes);
		
		return true;
	}
	
	
	
	private List<AssetType> getDefaultAssetTypes(String userEmail) {

		List<AssetType> defaultAssetTypes = new ArrayList<AssetType>();

		// ����
		AssetType wallet = new AssetType("����", userEmail);
		
		// ī��
		AssetType card = new AssetType("ī��", userEmail);
		card.addField(new Field("ī���"));
		card.addField(new Field("ī���ȣ"));
		card.addField(new Field("ȸ���"));

		// (�Ϲ�)����
		AssetType bank = new AssetType("�������", userEmail);
		bank.addField(new Field("�����"));
		bank.addField(new Field("���¹�ȣ"));
		
		// (����)����
		AssetType loan = new AssetType("����", userEmail);
		loan.addField(new Field("�����"));
		loan.addField(new Field("�����"));
		loan.addField(new Field("��ȯ������¹�ȣ"));
		loan.addField(new Field("��ȯ��"));
		loan.addField(new Field("�ѻ�ȯ�׼�"));
		loan.addField(new Field("�����׼�"));
		loan.addField(new Field("�ſ���ü�ݾ�"));
		
		// ����
		AssetType insurance = new AssetType("����", userEmail);
		insurance.addField(new Field("�����"));
		insurance.addField(new Field("���ð��¹�ȣ"));
		insurance.addField(new Field("�ſ������"));
		insurance.addField(new Field("��ü��"));
		
		// (����)����
		AssetType installmentSaving = new AssetType("����", userEmail);
		installmentSaving.addField(new Field("���ݸ�"));
		installmentSaving.addField(new Field("�����"));
		installmentSaving.addField(new Field("���¹�ȣ"));
		installmentSaving.addField(new Field("��ü�ݾ�"));
		installmentSaving.addField(new Field("��ü��"));
		installmentSaving.addField(new Field("������"));

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
