package com.appspot.egun.money.comp.domain.asset;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;

/**
 * 자산종류 (보험)
 * @author 이동규
 * @since 2011.07.10
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class InsuranceAssetType extends AbstractAssetType {
	
	/** 관련은행명 */
	private String transferBankName;
	
	/** 관련계좌번호 */
	private String transferAccountNumber;
	
	/** 보험료 */
	private String premium;
	
	/** 이체일 */
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
