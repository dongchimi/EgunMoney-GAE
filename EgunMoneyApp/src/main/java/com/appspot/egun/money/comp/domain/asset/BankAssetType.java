package com.appspot.egun.money.comp.domain.asset;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;

/**
 * 자산타입(은행계좌)
 * @author 이동규
 * @since 2011.07.24
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class BankAssetType extends AbstractAssetType {
	
	/** 은행명 */
	private String bankName;
	
	/** 계좌번호 */
	private String bankAccountNumber;
	
	/** 현재금액 */
	private String amount;

	public BankAssetType() {}
	public BankAssetType(String name) {
		super.setName(name);
	}
	
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankAccountNumber() {
		return bankAccountNumber;
	}
	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
}
