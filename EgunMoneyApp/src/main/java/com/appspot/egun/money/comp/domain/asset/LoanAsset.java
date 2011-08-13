package com.appspot.egun.money.comp.domain.asset;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

/**
 * �ڻ����� (��)
 * @author �̵���
 * @since 2011.07.24
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable="true")
public class LoanAsset {
	
	/** ������Ʈ id */
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key oid;
	
	/** �ڻ�� */
	@Persistent
	private String name;
	
	/** ����� */
	@Persistent
	private String bankName;
	
	/** ��ȯ������¹�ȣ */
	@Persistent
	private String bankAccountNumber;
	
	/** �ſ���ȯ�� */
	@Persistent
	private String monthlyMaturityDay;
	
	/** �Ѵ���׼�  */
	@Persistent
	private String totalLoanAmount;
	
	/** �����׼� */
	@Persistent
	private String remainLoanAmount;
	
	/** �ſ���ü�ݾ� */
	@Persistent
	private String monthlyTransferAmount;
	
	@Persistent
	private EgunUserAsset egunUserAsset;
	
	public LoanAsset() {}
	public LoanAsset(String name) {
		setName(name);
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
	public String getMonthlyMaturityDay() {
		return monthlyMaturityDay;
	}
	public void setMonthlyMaturityDay(String monthlyMaturityDay) {
		this.monthlyMaturityDay = monthlyMaturityDay;
	}
	public String getTotalLoanAmount() {
		return totalLoanAmount;
	}
	public void setTotalLoanAmount(String totalLoanAmount) {
		this.totalLoanAmount = totalLoanAmount;
	}
	public String getRemainLoanAmount() {
		return remainLoanAmount;
	}
	public void setRemainLoanAmount(String remainLoanAmount) {
		this.remainLoanAmount = remainLoanAmount;
	}
	public String getMonthlyTransferAmount() {
		return monthlyTransferAmount;
	}
	public void setMonthlyTransferAmount(String monthlyTransferAmount) {
		this.monthlyTransferAmount = monthlyTransferAmount;
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
