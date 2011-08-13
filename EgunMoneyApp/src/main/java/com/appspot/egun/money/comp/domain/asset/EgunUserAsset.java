package com.appspot.egun.money.comp.domain.asset;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * 자산
 * 
 * @author 이동규
 * @since 2011.02.04
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable="true")
public class EgunUserAsset {

	/** 오브젝트 id */
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long oid;

	/** 자산 주인 이메일 */
	@Persistent
	private String userEmail;
	
	@Persistent()
	@Element(dependent="true", mappedBy="egunUserAsset")
	private List<BankAsset> bankAssets = new ArrayList<BankAsset>();
	
	@Persistent
	@Element(dependent="true", mappedBy="egunUserAsset")
	private List<CheckCardAsset> checkCardAssets = new ArrayList<CheckCardAsset>();
	
	@Persistent
	@Element(dependent="true", mappedBy="egunUserAsset")
	private List<CreditCardAsset> creditCardAssets = new ArrayList<CreditCardAsset>();
	
	@Persistent
	@Element(dependent="true", mappedBy="egunUserAsset")
	private List<InsuranceAsset> insuranceAssets = new ArrayList<InsuranceAsset>();
	
	@Persistent
	@Element(dependent="true", mappedBy="egunUserAsset")
	private List<InvestmentAsset> inverInvestmentAssets = new ArrayList<InvestmentAsset>();
	
	@Persistent
	@Element(dependent="true", mappedBy="egunUserAsset")
	private List<LendAsset> lendAssets = new ArrayList<LendAsset>();
	
	@Persistent
	@Element(dependent="true", mappedBy="egunUserAsset")
	private List<LoanAsset> loanAssets = new ArrayList<LoanAsset>();
	
	@Persistent
	@Element(dependent="true", mappedBy="egunUserAsset")
	private List<WalletAsset> walletAssets = new ArrayList<WalletAsset>();
	
	public EgunUserAsset(String userEmail) {
		this.userEmail = userEmail;
		
		this.addWalletAsset( new WalletAsset("내지갑") );
	}
	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public List<BankAsset> getBankAssets() {
		return bankAssets;
	}
	public void setBankAssets(List<BankAsset> bankAssets) {
		this.bankAssets = bankAssets;
	}
	public List<CheckCardAsset> getCheckCardAssets() {
		return checkCardAssets;
	}
	public void setCheckCardAssets(List<CheckCardAsset> checkCardAssets) {
		this.checkCardAssets = checkCardAssets;
	}
	public List<CreditCardAsset> getCreditCardAssets() {
		return creditCardAssets;
	}
	public void setCreditCardAssets(List<CreditCardAsset> creditCardAssets) {
		this.creditCardAssets = creditCardAssets;
	}
	public List<InsuranceAsset> getInsuranceAssets() {
		return insuranceAssets;
	}
	public void setInsuranceAssets(List<InsuranceAsset> insuranceAssets) {
		this.insuranceAssets = insuranceAssets;
	}
	public List<InvestmentAsset> getInverInvestmentAssets() {
		return inverInvestmentAssets;
	}
	public void setInverInvestmentAssets(List<InvestmentAsset> inverInvestmentAssets) {
		this.inverInvestmentAssets = inverInvestmentAssets;
	}
	public List<LendAsset> getLendAssets() {
		return lendAssets;
	}
	public void setLendAssets(List<LendAsset> lendAssets) {
		this.lendAssets = lendAssets;
	}
	public List<LoanAsset> getLoanAssets() {
		return loanAssets;
	}
	public void setLoanAssets(List<LoanAsset> loanAssets) {
		this.loanAssets = loanAssets;
	}
	public List<WalletAsset> getWalletAssets() {
		return walletAssets;
	}
	public void setWalletAssets(List<WalletAsset> walletAssets) {
		this.walletAssets = walletAssets;
	}
	public void addWalletAsset(WalletAsset walletAsset) {
		this.walletAssets.add(walletAsset);
	}
}
