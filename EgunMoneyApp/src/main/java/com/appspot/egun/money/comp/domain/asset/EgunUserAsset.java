package com.appspot.egun.money.comp.domain.asset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.NotPersistent;
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
	
	@Persistent(mappedBy="egunUserAsset", defaultFetchGroup = "true")
	@Element(dependent="true")
	private List<BankAsset> bankAssets = new ArrayList<BankAsset>();
	
	@Persistent(mappedBy="egunUserAsset", defaultFetchGroup = "true")
	@Element(dependent="true")
	private List<CheckCardAsset> checkCardAssets = new ArrayList<CheckCardAsset>();
	
	@Persistent(mappedBy="egunUserAsset", defaultFetchGroup = "true")
	@Element(dependent="true")
	private List<CreditCardAsset> creditCardAssets = new ArrayList<CreditCardAsset>();
	
	@Persistent(mappedBy="egunUserAsset", defaultFetchGroup = "true")
	@Element(dependent="true")
	private List<InsuranceAsset> insuranceAssets = new ArrayList<InsuranceAsset>();
	
	@Persistent(mappedBy="egunUserAsset", defaultFetchGroup = "true")
	@Element(dependent="true")
	private List<InvestmentAsset> investmentAssets = new ArrayList<InvestmentAsset>();
	
	@Persistent(mappedBy="egunUserAsset", defaultFetchGroup = "true")
	@Element(dependent="true")
	private List<LendAsset> lendAssets = new ArrayList<LendAsset>();
	
	@Persistent(mappedBy="egunUserAsset", defaultFetchGroup = "true")
	@Element(dependent="true")
	private List<LoanAsset> loanAssets = new ArrayList<LoanAsset>();
	
	@Persistent(mappedBy="egunUserAsset", defaultFetchGroup = "true")
	@Element(dependent="true")
	private List<WalletAsset> walletAssets = new ArrayList<WalletAsset>();
	
	/** 사용자 자산 목록 */
	@NotPersistent
	private List<Asset> assets = new ArrayList<Asset>();
	
	public EgunUserAsset(String userEmail) {
		this.userEmail = userEmail;
		
		addWalletAsset( new WalletAsset("내지갑") );
	}
	
	public void buildForUI() {
		if (this.assets == null) {
			this.assets = new ArrayList<Asset>(); 
		}
		for (WalletAsset wallAsset : walletAssets) {
			this.assets.add(wallAsset);
		}
		for (LoanAsset loanAsset : loanAssets) {
			this.assets.add(loanAsset);
		}
		for (LendAsset lendAsset : lendAssets) {
			this.assets.add(lendAsset);
		}
		for (InvestmentAsset investmentAsset : investmentAssets) {
			this.assets.add(investmentAsset);
		}
		for (InsuranceAsset insuranceAsset : insuranceAssets) {
			this.assets.add(insuranceAsset);
		}
		for (CreditCardAsset creditCardAsset : creditCardAssets) {
			this.assets.add(creditCardAsset);
		}
		for (CheckCardAsset checkCardAsset : checkCardAssets) {
			this.assets.add(checkCardAsset);
		}
		for (BankAsset bankAsset : bankAssets) {
			this.assets.add(bankAsset);
		}
		
		Collections.sort(assets);

		walletAssets = null;
		loanAssets = null;
		lendAssets = null;
		investmentAssets = null;
		insuranceAssets = null;
		creditCardAssets = null;
		checkCardAssets = null;
		bankAssets = null;
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
	public void addBankAsset(BankAsset bankAsset) {
		this.bankAssets.add(bankAsset);
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
	public void addAsset(Asset myAsset) {
		this.assets.add(myAsset);
	}

	public List<InvestmentAsset> getInvestmentAssets() {
		return investmentAssets;
	}

	public void setInvestmentAssets(List<InvestmentAsset> investmentAssets) {
		this.investmentAssets = investmentAssets;
	}

	public List<Asset> getAssets() {
		return assets;
	}

	public void setAssets(List<Asset> assets) {
		this.assets = assets;
	}
}
