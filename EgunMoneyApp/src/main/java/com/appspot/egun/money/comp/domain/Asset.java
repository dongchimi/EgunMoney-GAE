package com.appspot.egun.money.comp.domain;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

/**
 * 자산
 * @author 이동규
 * @since 2011.02.04
 */
@PersistenceCapable(identityType=IdentityType.DATASTORE)
public class Asset implements Serializable {

	/** UID */
	private static final long serialVersionUID = -133163918230430168L;

	/** 오브젝트 id */
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key oid;
	
	/** 명칭 */
	private String name;
	
	/** 종류 */
	private AssetType type;
	
	/** 메모 */
	private String description;
	
	/** 은행명 */
	private String bank;
	
	/** 계좌번호 */
	private String accountNumber;
	
	/** 카드회사명 */
	private String cardCompanyName;
	
	/** 결제일 */
	private String paymentDay;
	
	/** 전화번호 */
	private String phoneNumber;
	
	/** 색상 */
	private String color;
	
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
	public AssetType getType() {
		return type;
	}
	public void setType(AssetType type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getCardCompanyName() {
		return cardCompanyName;
	}
	public void setCardCompanyName(String cardCompanyName) {
		this.cardCompanyName = cardCompanyName;
	}
	public String getPaymentDay() {
		return paymentDay;
	}
	public void setPaymentDay(String paymentDay) {
		this.paymentDay = paymentDay;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
}
