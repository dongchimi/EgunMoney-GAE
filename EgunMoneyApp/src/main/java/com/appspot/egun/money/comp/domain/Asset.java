package com.appspot.egun.money.comp.domain;

import java.io.Serializable;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * �ڻ�
 * 
 * @author �̵���
 * @since 2011.02.04
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Asset implements Serializable {

	/** UID */
	private static final long serialVersionUID = -6709003541622818799L;

	/** ������Ʈ id */
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long oid;

	/** �̸� */
	@Persistent
	private String name;

	/** ���� */
	@Persistent
	private AssetType type;
	
	/** �ڻ� ���� �̸��� */
	@Persistent
	private String userEmail;

	/** �߰� �ʵ��.. Ÿ�Կ� ���� ����� */
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
