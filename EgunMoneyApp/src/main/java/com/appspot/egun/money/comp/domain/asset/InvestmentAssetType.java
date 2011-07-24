package com.appspot.egun.money.comp.domain.asset;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;

/**
 * 자산종류 (투자)
 * @author 이동규
 * @since 2011.07.24
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class InvestmentAssetType extends AbstractAssetType {
	
	/** 투자은행명 */
	private String investmentBankName;
	
	/** 투자은행계좌 */
	private String investmentBankAccount;
	
	/** 총투자금액 */
	private String totalInvestmentAmount;
	
	/** 매월투자금액 */
	private String monthlyInvestmentAmount;
	
	/** 매월이체일 */
	private String monthlyTransferDay;
	
	/** 만기일 */
	private String endDate;

	public InvestmentAssetType() {}
	public InvestmentAssetType(String name) {
		super.setName(name);
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
}
