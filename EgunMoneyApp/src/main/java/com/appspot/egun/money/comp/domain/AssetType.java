package com.appspot.egun.money.comp.domain;

import java.io.Serializable;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * 자산종류 (현금, 은행계좌, 카드, 대출원금, 대출원금, 대출이자, 적금, 보험) 등등
 * @author 이동규
 * @since 2011.07.10
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class AssetType implements Serializable {
	
	/** UID */
	private static final long serialVersionUID = 2214946206362484951L;

	/** 오브젝트 id */
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long oid;
	
	/** 자산 종류 명 */
	private String name;
	
	/** 사용자 이메일 */
	private String userEmail;
	
	/** 자산 종류 기준 필드 */
	private List<Field> fields;
	
	public AssetType() {}
	public AssetType(String name, String email) {
		this.name = name;
		this.userEmail = email;
	}
	
	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Field> getFields() {
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
}
