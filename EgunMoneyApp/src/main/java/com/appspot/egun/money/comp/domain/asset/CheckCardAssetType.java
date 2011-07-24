package com.appspot.egun.money.comp.domain.asset;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;

/**
 * �ڻ����� (üũī��)
 * @author �̵���
 * @since 2011.07.24
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class CheckCardAssetType extends AbstractAssetType {
	
	/** ī���ȣ */
	private String cardNumber;
	
	/** ȸ��� */
	private String companyName;

	public CheckCardAssetType() {}
	public CheckCardAssetType(String name) {
		super.setName(name);
	}
	
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
}
