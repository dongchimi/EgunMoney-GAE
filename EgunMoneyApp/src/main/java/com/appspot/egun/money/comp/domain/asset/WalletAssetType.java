package com.appspot.egun.money.comp.domain.asset;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;

/**
 * 자산종류 (지갑) 등등
 * @author 이동규
 * @since 2011.07.24
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class WalletAssetType extends AbstractAssetType {
	
	/** 현재금액 */
	private String amount;

	public WalletAssetType() {}
	public WalletAssetType(String name) {
		super.setName(name);
	}
	
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
}
