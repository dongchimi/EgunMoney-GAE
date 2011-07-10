package com.appspot.egun.money.comp.domain;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.appspot.egun.money.comp.utility.StringU;

/**
 * �̰ǸӴ� �����
 * 
 * @author dklee
 * @since 2010.08.31
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class EgunUser implements Serializable {

	/** UID */
	private static final long serialVersionUID = -8986058610180702616L;

	/** ������Ʈ id */
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long oid;

	/** ��й�ȣ */
	@Persistent
	private String password;

	/** �̸��� */
	@Persistent
	private String userEmail;

	/** ���� */
	@Persistent
	private String nickName;
	
	/** ���� ��ū */
	@Persistent
	private String authToken;

	public boolean samePassword(String sourcePassword) {
		boolean same = false;

		if (!StringU.isEmptyOrNull(sourcePassword)) {
			same = sourcePassword.equals(password);
		}
		return same;
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

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
}
