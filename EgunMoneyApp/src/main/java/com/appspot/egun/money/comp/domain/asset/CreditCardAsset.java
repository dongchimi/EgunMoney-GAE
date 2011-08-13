package com.appspot.egun.money.comp.domain.asset;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

/**
 * 자산종류 (신용카드)
 * @author 이동규
 * @since 2011.07.24
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable="true")
public class CreditCardAsset {
	
	/** 오브젝트 id */
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key oid;
	
	/** 자산명 */
	@Persistent
	private String name;
	
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
	
	@Persistent
	private EgunUserAsset egunUserAsset;
	

	public CreditCardAsset() {}
	public CreditCardAsset(String name) {
		setName(name);
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
	public Key getOid() {
		return oid;
	}
	public void setOid(Key oid) {
		this.oid = oid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public EgunUserAsset getEgunUserAsset() {
		return egunUserAsset;
	}
	public void setEgunUserAsset(EgunUserAsset egunUserAsset) {
		this.egunUserAsset = egunUserAsset;
	}
}
