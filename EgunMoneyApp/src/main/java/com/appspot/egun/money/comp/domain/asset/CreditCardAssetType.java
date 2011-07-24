package com.appspot.egun.money.comp.domain.asset;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

/**
 * 자산종류 (신용카드)
 * @author 이동규
 * @since 2011.07.24
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class CreditCardAssetType extends AbstractAssetType {
	
	/** 카드번호 */
	@Persistent
	private String cardNumber;
	
	/** 회사명 */
	@Persistent
	private String companyName;
	
	/** 정산일 */
	@Persistent
	private String calculateDay;
	
	/** 결제일 */
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
