package com.appspot.egun.money.comp.domain.asset;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;

/**
 * �ڻ����� (����)
 * @author �̵���
 * @since 2011.07.10
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class InsuranceAssetType extends AbstractAssetType {
	
	/** ��������� */
	private String transferBankName;
	
	/** ���ð��¹�ȣ */
	private String transferAccountNumber;
	
	/** ����� */
	private String premium;
	
	/** ��ü�� */
	private String transferDay;

	public InsuranceAssetType() {}
	public InsuranceAssetType(String name) {
		super.setName(name);
	}
	
	public String getTransferBankName() {
		return transferBankName;
	}
	public void setTransferBankName(String transferBankName) {
		this.transferBankName = transferBankName;
	}
	public String getTransferAccountNumber() {
		return transferAccountNumber;
	}
	public void setTransferAccountNumber(String transferAccountNumber) {
		this.transferAccountNumber = transferAccountNumber;
	}
	public String getPremium() {
		return premium;
	}
	public void setPremium(String premium) {
		this.premium = premium;
	}
	public String getTransferDay() {
		return transferDay;
	}
	public void setTransferDay(String transferDay) {
		this.transferDay = transferDay;
	}
}
