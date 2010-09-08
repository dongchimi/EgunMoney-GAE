package com.appspot.egunmoney.domain;

import java.io.Serializable;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * 이건머니 사용자
 * @author dklee
 * @since 2010.08.31
 */
@PersistenceCapable
public class EgunUser implements Serializable{
	
	/** UID */
	private static final long serialVersionUID = 6726740521064705083L;

	/** 오브젝트 id */
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long oid;
	
	/** 비밀번호 */
	@Persistent
	private String password;
	
	/** 이메일 - key */
	@Persistent
	private String userEmail;
	
	/** 별명 */
	@Persistent
	private String nickName;
	
	/** 가계부 */
	@Persistent
	private List<EgunAccountBook> accountBooks;
	
	/** 가계부 사용 권한 */
	@Persistent
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
}
