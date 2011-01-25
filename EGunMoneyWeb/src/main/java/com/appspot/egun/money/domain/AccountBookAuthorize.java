package com.appspot.egun.money.domain;

import java.io.Serializable;
import java.util.List;

/**
 * ����� ����
 * @author dklee
 *
 */
public class AccountBookAuthorize implements Serializable{
	
	/** UID */
	private static final long serialVersionUID = 3826375588748184957L;

	/** ���� id */
	private long authorizeId;
	
	/** ����� id */
	private long accountBookId;
	
	/** ����� e-���� */
	private String userEmail;
	
	/** ����� ���� */
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
