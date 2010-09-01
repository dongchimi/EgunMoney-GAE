package com.appspot.egunmoney.domain;

import java.util.List;

/**
 * 이건머니 사용자
 * @author dklee
 * @since 2010.08.31
 */
public class EgunUser {
	
	/** 오브젝트 id */
	private int oid;
	
	// method ------------------------------------------------------------------
	
	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	/** 이메일 - key */
	private String email;
	
	/** 별명 */
	private String nickName;
	
	/** 가계부 */
	private List<EgunAccountBook> accountBooks;

	/** 가계부 사용 권한 */
	private List<AccountBookAuthorize> bookAuthorizes;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<EgunAccountBook> getAccountBooks() {
		return accountBooks;
	}

	public void setAccountBooks(List<EgunAccountBook> accountBooks) {
		this.accountBooks = accountBooks;
	}

	public List<AccountBookAuthorize> getBookAuthorizes() {
		return bookAuthorizes;
	}

	public void setBookAuthorizes(List<AccountBookAuthorize> bookAuthorizes) {
		this.bookAuthorizes = bookAuthorizes;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
}
