package com.appspot.egun.money.comp.domain;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * �ڻ����� (����, �������, ī��, �������, �������, ��������, ����, ����) ���
 * @author �̵���
 * @since 2011.07.10
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class AssetType {
	
	/** ������Ʈ id */
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long oid;
	
	/** �ڻ� ���� �� */
	@Persistent
	private String name;
	
	/** ����� �̸��� */
	@Persistent
	private String userEmail;
	
	/** �ڻ� ���� ���� �ʵ� oid */
	@Persistent
	private List<Long> fieldOids = new ArrayList<Long>(10);
	
	/** �ڻ� ���� ���� �ʵ�  */
	@NotPersistent
	private List<Field> fields = new ArrayList<Field>(10);
	
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

	public void addFieldOid(Long fieldOid) {
		this.fieldOids.add(fieldOid);
	}
	
	public void addField(Field field) {
		this.fields.add(field);
	}
	
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public List<Long> getFieldOids() {
		return fieldOids;
	}
	public void setFieldOids(List<Long> fieldOids) {
		this.fieldOids = fieldOids;
	}
	public List<Field> getFields() {
		return fields;
	}
	public void setFields(List<Field> fields) {
		this.fields = fields;
	}
}
