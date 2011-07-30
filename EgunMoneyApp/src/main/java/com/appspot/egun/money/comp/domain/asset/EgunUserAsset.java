package com.appspot.egun.money.comp.domain.asset;

import java.util.ArrayList;
import java.util.List;

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
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class EgunUserAsset {

	/** 오브젝트 id */
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long oid;

	/** 자산 주인 이메일 */
	@Persistent
	private String userEmail;

	/** 자산 목록 */
	@Persistent()
	private List<Long> assetOids = new ArrayList<Long>();
	
	@NotPersistent
	private List<AbstractAssetType> assets = null;
	
	public EgunUserAsset(String userEmail) {
		this.userEmail = userEmail;
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

	public List<Long> getAssetOids() {
		return assetOids;
	}

	public void setAssetOids(List<Long> assetOids) {
		this.assetOids = assetOids;
	}
	
	public void addAssetOid(Long assetOid) {
		this.assetOids.add(assetOid);
	}
	public List<AbstractAssetType> getAssets() {
		return assets;
	}
	public void setAssets(List<AbstractAssetType> assets) {
		this.assets = assets;
	}
}
