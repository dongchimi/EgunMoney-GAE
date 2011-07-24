package com.appspot.egun.money.comp.domain.asset;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;

/**
 * �ڻ����� (����) ���
 * @author �̵���
 * @since 2011.07.24
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class WalletAssetType extends AbstractAssetType {
	
	/** ����ݾ� */
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
