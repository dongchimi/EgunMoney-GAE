package com.appspot.egun.money.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 가계부 권한
 * @author dklee
 *
 */
public class AccountBookAuthorize implements Serializable{
	
	/** UID */
	private static final long serialVersionUID = 3826375588748184957L;

	/** 권한 id */
	private long authorizeId;
	
	/** 가계부 id */
	private long accountBookId;
	
	/** 사용자 e-메일 */
	private String userEmail;
	
	/** 가계부 권한 */
	private List<EgunAuthorize> authorizes;
	
	// method ------------------------------------------------------------------
	
	public long getAuthorizeId() {
		return authorizeId;
	}

	public void setAuthorizeId(long authorizeId) {
		this.authorizeId = authorizeId;
	}

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

	public List<EgunAuthorize> getAuthorizes() {
		return authorizes;
	}

	public void setAuthorizes(List<EgunAuthorize> authorizes) {
		this.authorizes = authorizes;
	}
}
