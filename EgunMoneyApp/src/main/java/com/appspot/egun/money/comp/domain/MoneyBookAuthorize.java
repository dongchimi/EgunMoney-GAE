package com.appspot.egun.money.comp.domain;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * 가계부 권한
 * 
 * @author dklee
 * 
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class MoneyBookAuthorize {

	/** 오브젝트 id */
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long oid;

	/** 가계부 id */
	@Persistent
	private Long moneyBookOid;

	/** 사용자 e-메일 */
	@Persistent
	private String userEmail;

	/** 가계부 권한 */
	@Persistent
	private Authorize authorize;

	// method ------------------------------------------------------------------
	public MoneyBookAuthorize(String userEmail, Long accountBookOid) {
		this.userEmail = userEmail;
		this.moneyBookOid = accountBookOid;

		authorize = Authorize.READ_WRITE;
	}

	public MoneyBookAuthorize(String userEmail, Long accountBookOid, Authorize authorize) {
		this.userEmail = userEmail;
		this.moneyBookOid = accountBookOid;
		this.authorize = authorize;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public Authorize getAuthorize() {
		return authorize;
	}

	public void setAuthorize(Authorize authorize) {
		this.authorize = authorize;
	}

	public Long getMoneyBookOid() {
		return moneyBookOid;
	}

	public void setMoneyBookOid(Long moneyBookOid) {
		this.moneyBookOid = moneyBookOid;
	}

}
