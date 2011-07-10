package com.appspot.egun.money.comp.domain;

import java.io.Serializable;

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
public class Field implements Serializable{

	/** UID */
	private static final long serialVersionUID = -3285435722401723395L;

	/** ������Ʈ id */
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long oid;

	/** �ʵ� �� */
	private String name;
	
	/** �ʵ� �� */
	private String value;
	
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
