package com.appspot.egun.money.domain;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

/**
 * ����� ����
 * @author dklee
 *
 */
public class AccountBookAuthorize implements Serializable{
	
	/** UID */
	private static final long serialVersionUID = 3826375588748184957L;
	
	/** ������Ʈ id */
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key oid;

	/** ����� id */
	private long accountBookId;
	
	/** ����� e-���� */
	private String userEmail;
	
	/** ����� ���� */
	private EgunAuthorize authorize;
	
	// method ------------------------------------------------------------------
	public long getAccountBookId() {
		return accountBookId;
	}

	public void setAccountBookId(long accountBookId) {
		this.accountBookId = accountBookId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Key getOid() {
		return oid;
	}

	public void setOid(Key oid) {
		this.oid = oid;
	}

	public EgunAuthorize getAuthorize() {
		return authorize;
	}

	public void setAuthorize(EgunAuthorize authorize) {
		this.authorize = authorize;
	}
}
