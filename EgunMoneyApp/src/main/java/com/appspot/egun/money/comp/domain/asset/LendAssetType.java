package com.appspot.egun.money.comp.domain.asset;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;

/**
 * 자산종류 (빌려줌) 등등
 * @author 이동규
 * @since 2011.07.24
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class LendAssetType extends AbstractAssetType {
	
	/** 빌려준 대상명 */
	private String targetName;
	
	/** 빌려준 돈 */
	private String lendAmount;
	
	/** 상환일 */
	private String maturityDate;

	public LendAssetType() {}
	public LendAssetType(String name) {
		super.setName(name);
	}
	
	public String getTargetName() {
		return targetName;
	}
	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}
	public String getLendAmount() {
		return lendAmount;
	}
	public void setLendAmount(String lendAmount) {
		this.lendAmount = lendAmount;
	}
	public String getMaturityDate() {
		return maturityDate;
	}
	public void setMaturityDate(String maturityDate) {
		this.maturityDate = maturityDate;
	}
}
