package com.appspot.egun.money.comp.domain;

import java.io.Serializable;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * 자산
 * 
 * @author 이동규
 * @since 2011.02.04
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Asset implements Serializable {

	/** UID */
	private static final long serialVersionUID = -6709003541622818799L;

	/** 오브젝트 id */
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long oid;

	/** 이름 */
	@Persistent
	private String name;

	/** 종류 */
	@Persistent
	private AssetType type;
	
	/** 자산 주인 이메일 */
	@Persistent
	private String userEmail;

	/** 추가 필드들.. 타입에 따라 변경됨 */
	private List<Field> fields;
	
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

	public AssetType getType() {
		return type;
	}

	public void setType(AssetType type) {
		this.type = type;
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
