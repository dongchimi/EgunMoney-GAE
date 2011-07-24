package com.appspot.egun.money.comp.domain;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * 이건머니 설정
 * 
 * @author 이동규
 * @since 2011.02.04
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class EgunMoneyPreference {

	/** 오브젝트 id */
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long oid;
	
	/** 자동 로그인 여부*/
	@Persistent
	private boolean autoSignin = false;

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public boolean isAutoSignin() {
		return autoSignin;
	}

	public void setAutoSignin(boolean autoSignin) {
		this.autoSignin = autoSignin;
	}
}
