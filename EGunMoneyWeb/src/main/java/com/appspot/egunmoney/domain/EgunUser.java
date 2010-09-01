package com.appspot.egunmoney.domain;

import java.util.List;

/**
 * �̰ǸӴ� �����
 * @author dklee
 * @since 2010.08.31
 */
public class EgunUser {
	
	/** ������Ʈ id */
	private int oid;
	
	// method ------------------------------------------------------------------
	
	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	/** �̸��� - key */
	private String email;
	
	/** ���� */
	private String nickName;
	
	/** ����� */
	private List<EgunAccountBook> accountBooks;

	/** ����� ��� ���� */
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
