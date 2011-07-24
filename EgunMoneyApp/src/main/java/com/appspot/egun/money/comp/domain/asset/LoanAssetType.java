package com.appspot.egun.money.comp.domain.asset;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;

/**
 * 자산종류 (빚)
 * @author 이동규
 * @since 2011.07.24
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class LoanAssetType extends AbstractAssetType {
	
	/** 은행명 */
	private String bankName;
	
	/** 상환은행계좌번호 */
	private String bankAccountNumber;
	
	/** 매월상환일 */
	private String monthlyMaturityDay;
	
	/** 총대출액수  */
	private String totalLoanAmount;
	
	/** 남은액수 */
	private String remainLoanAmount;
	
	/** 매월이체금액 */
	private String monthlyTransferAmount;
	
	public LoanAssetType() {}
	public LoanAssetType(String name) {
		super.setName(name);
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
}
