package com.appspot.egun.money.comp.domain.asset;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;

/**
 * �ڻ����� (��)
 * @author �̵���
 * @since 2011.07.24
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class LoanAssetType extends AbstractAssetType {
	
	/** ����� */
	private String bankName;
	
	/** ��ȯ������¹�ȣ */
	private String bankAccountNumber;
	
	/** �ſ���ȯ�� */
	private String monthlyMaturityDay;
	
	/** �Ѵ���׼�  */
	private String totalLoanAmount;
	
	/** �����׼� */
	private String remainLoanAmount;
	
	/** �ſ���ü�ݾ� */
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
