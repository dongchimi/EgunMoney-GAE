package com.appspot.egun.money.comp.domain;

import java.io.Serializable;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * �ڻ����� (����, �������, ī��, �������, �������, ��������, ����, ����) ���
 * @author �̵���
 * @since 2011.07.10
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class AssetType implements Serializable {
	
	/** UID */
	private static final long serialVersionUID = 2214946206362484951L;

	/** ������Ʈ id */
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long oid;
	
	/** �ڻ� ���� �� */
	private String name;
	
	/** ����� �̸��� */
	private String userEmail;
	
	/** �ڻ� ���� ���� �ʵ� */
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
