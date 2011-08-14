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
 * @since 2011.07.24
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable="true")
public class InvestmentAsset extends Asset {
	
	/** ������Ʈ id */
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key oid;
	
	/** �ڻ�� */
	@Persistent
	private String name;
	
	/** ��������� */
	@Persistent
	private String investmentBankName;
	
	/** ����������� */
	@Persistent
	private String investmentBankAccount;
	
	/** �����ڱݾ� */
	@Persistent
	private String totalInvestmentAmount;
	
	/** �ſ����ڱݾ� */
	@Persistent
	private String monthlyInvestmentAmount;
	
	/** �ſ���ü�� */
	@Persistent
	private String monthlyTransferDay;
	
	/** ������ */
	@Persistent
	private String endDate;
	
	@Persistent
	private EgunUserAsset egunUserAsset;
	
	public InvestmentAsset() {}
	public InvestmentAsset(String name) {
		setName(name);
	}
	
	public String getInvestmentBankName() {
		return investmentBankName;
	}
	public void setInvestmentBankName(String investmentBankName) {
		this.investmentBankName = investmentBankName;
	}
	public String getInvestmentBankAccount() {
		return investmentBankAccount;
	}
	public void setInvestmentBankAccount(String investmentBankAccount) {
		this.investmentBankAccount = investmentBankAccount;
	}
	public String getTotalInvestmentAmount() {
		return totalInvestmentAmount;
	}
	public void setTotalInvestmentAmount(String totalInvestmentAmount) {
		this.totalInvestmentAmount = totalInvestmentAmount;
	}
	public String getMonthlyInvestmentAmount() {
		return monthlyInvestmentAmount;
	}
	public void setMonthlyInvestmentAmount(String monthlyInvestmentAmount) {
		this.monthlyInvestmentAmount = monthlyInvestmentAmount;
	}
	public String getMonthlyTransferDay() {
		return monthlyTransferDay;
	}
	public void setMonthlyTransferDay(String monthlyTransferDay) {
		this.monthlyTransferDay = monthlyTransferDay;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
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
