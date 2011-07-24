package com.appspot.egun.money.comp.domain.asset;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;

/**
 * �ڻ����� (����)
 * @author �̵���
 * @since 2011.07.24
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class InvestmentAssetType extends AbstractAssetType {
	
	/** ��������� */
	private String investmentBankName;
	
	/** ����������� */
	private String investmentBankAccount;
	
	/** �����ڱݾ� */
	private String totalInvestmentAmount;
	
	/** �ſ����ڱݾ� */
	private String monthlyInvestmentAmount;
	
	/** �ſ���ü�� */
	private String monthlyTransferDay;
	
	/** ������ */
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
