package com.appspot.egun.money.comp.domain.asset;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

/**
 * 자산종류 (투자)
 * @author 이동규
 * @since 2011.07.24
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable="true")
public class InvestmentAsset extends Asset {
	
	/** 오브젝트 id */
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key oid;
	
	/** 자산명 */
	@Persistent
	private String name;
	
	/** 투자은행명 */
	@Persistent
	private String investmentBankName;
	
	/** 투자은행계좌 */
	@Persistent
	private String investmentBankAccount;
	
	/** 총투자금액 */
	@Persistent
	private String totalInvestmentAmount;
	
	/** 매월투자금액 */
	@Persistent
	private String monthlyInvestmentAmount;
	
	/** 매월이체일 */
	@Persistent
	private String monthlyTransferDay;
	
	/** 만기일 */
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
