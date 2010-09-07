package com.appspot.egunmoney.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 이건머니 사용자
 * @author dklee
 * @since 2010.08.31
 */
public class EgunUser implements Serializable{
	
	/** UID */
	private static final long serialVersionUID = 6726740521064705083L;

	/** 오브젝트 id */
	private int oid;
	
	/** 비밀번호 */
	private String password;
	
	/** 이메일 - key */
	private String userEmail;
	
	/** 별명 */
	private String nickName;
	
	/** 가계부 */
	private List<EgunAccountBook> accountBooks;
	
	/** 가계부 사용 권한 */
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
