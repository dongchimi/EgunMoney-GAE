package com.appspot.egun.money.comp.domain;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * �߰� �ʵ�
 * 
 * @author dklee
 * @since 2011.07.10
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Field {

	/** ������Ʈ id */
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long oid;

	/** �ʵ� �� */
	@Persistent
	private String fieldName;
	
	/** �ʵ� �� */
	@Persistent
	private String value;
	
	public Field() {}
	public Field(String name) {
		this.fieldName = name;
	}
	
	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
}
