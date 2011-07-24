package com.appspot.egun.money.comp.domain.asset;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;

/**
 * �ڻ����� (������) ���
 * @author �̵���
 * @since 2011.07.24
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class LendAssetType extends AbstractAssetType {
	
	/** ������ ���� */
	private String targetName;
	
	/** ������ �� */
	private String lendAmount;
	
	/** ��ȯ�� */
	private String maturityDate;

	public LendAssetType() {}
	public LendAssetType(String name) {
		super.setName(name);
	}
	
	public String getTargetName() {
		return targetName;
	}
	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}
	public String getLendAmount() {
		return lendAmount;
	}
	public void setLendAmount(String lendAmount) {
		this.lendAmount = lendAmount;
	}
	public String getMaturityDate() {
		return maturityDate;
	}
	public void setMaturityDate(String maturityDate) {
		this.maturityDate = maturityDate;
	}
}
