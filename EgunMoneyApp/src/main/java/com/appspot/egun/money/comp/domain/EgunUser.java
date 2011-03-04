package com.appspot.egun.money.comp.domain;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.appspot.egun.money.comp.utility.SU;

/**
 * 이건머니 사용자
 * @author dklee
 * @since 2010.08.31
 */
@PersistenceCapable(identityType=IdentityType.APPLICATION)
public class EgunUser implements Serializable {
	
	/** UID */
	private static final long serialVersionUID = 924101381822315782L;

	/** 오브젝트 id */
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long oid;
	
	/** 비밀번호 */
	@Persistent
	private String password;
	
	/** 이메일 */
	@Persistent
	private String userEmail;
	
	/** 별명 */
	@Persistent
	private String nickName;
	
	/** 가계부 사용 권한 */
	//private List<AccountBookAuthorize> bookAuthorizes;
	
	// method ------------------------------------------------------------------
//	public List<AccountBookAuthorize> getBookAuthorizes() {
//		return bookAuthorizes;
//	}
//
//	public void setBookAuthorizes(List<AccountBookAuthorize> bookAuthorizes) {
//		this.bookAuthorizes = bookAuthorizes;
//	}
//	
//	public void addBookAuthorize(AccountBookAuthorize bookAuthorize) {
//		if (this.bookAuthorizes == null) {
//			bookAuthorizes = new ArrayList<AccountBookAuthorize>();
//		}
//		
//		bookAuthorizes.add(bookAuthorize);
//	}

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
	
	public boolean samePassword(String sourcePassword) {
		boolean same = false;
		
		if ( !SU.isEmptyOrNull(sourcePassword) ) {
			same = sourcePassword.equals(password);
		}
		return same;
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
