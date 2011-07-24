package com.appspot.egun.money.comp.domain.asset;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

/**
 * �ڻ����� (�ſ�ī��)
 * @author �̵���
 * @since 2011.07.24
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class CreditCardAssetType extends AbstractAssetType {
	
	/** ī���ȣ */
	@Persistent
	private String cardNumber;
	
	/** ȸ��� */
	@Persistent
	private String companyName;
	
	/** ������ */
	@Persistent
	private String calculateDay;
	
	/** ������ */
	@Persistent
	private String paymentDay;

	public CreditCardAssetType() {}
	public CreditCardAssetType(String name) {
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
	public String getCalculateDay() {
		return calculateDay;
	}
	public void setCalculateDay(String calculateDay) {
		this.calculateDay = calculateDay;
	}
	public String getPaymentDay() {
		return paymentDay;
	}
	public void setPaymentDay(String paymentDay) {
		this.paymentDay = paymentDay;
	}
}
