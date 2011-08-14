package com.appspot.egun.money.comp.domain.asset;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

/**
 * �ڻ����� (����)
 * @author �̵���
 * @since 2011.07.10
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable="true")
public class InsuranceAsset extends Asset {
	
	/** ������Ʈ id */
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key oid;
	
	/** �ڻ�� */
	@Persistent
	private String name;
	
	/** ��������� */
	@Persistent
	private String transferBankName;
	
	/** ���ð��¹�ȣ */
	@Persistent
	private String transferAccountNumber;
	
	/** ����� */
	@Persistent
	private String premium;
	
	/** ��ü�� */
	@Persistent
	private String transferDay;
	
	@Persistent
	private EgunUserAsset egunUserAsset;
	
	public InsuranceAsset() {}
	public InsuranceAsset(String name) {
		setName(name);
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
