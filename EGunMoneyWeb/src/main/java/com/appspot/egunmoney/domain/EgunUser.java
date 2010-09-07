package com.appspot.egunmoney.domain;

import java.io.Serializable;
import java.util.List;

/**
 * �̰ǸӴ� �����
 * @author dklee
 * @since 2010.08.31
 */
public class EgunUser implements Serializable{
	
	/** UID */
	private static final long serialVersionUID = 6726740521064705083L;

	/** ������Ʈ id */
	private int oid;
	
	/** ��й�ȣ */
	private String password;
	
	/** �̸��� - key */
	private String userEmail;
	
	/** ���� */
	private String nickName;
	
	/** ����� */
	private List<EgunAccountBook> accountBooks;
	
	/** ����� ��� ���� */
	private List<AccountBookAuthorize> bookAuthorizes;
	
	// method ------------------------------------------------------------------
	
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
}
