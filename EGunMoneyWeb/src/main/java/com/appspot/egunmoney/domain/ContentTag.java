package com.appspot.egunmoney.domain;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * �±�
 * ��) @�׳������
 * @author dklee
 * @since 2010.09.01
 */
@PersistenceCapable(identityType=IdentityType.DATASTORE)
public class ContentTag {
	
	/** ������Ʈ id */
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private int oid;

	/** �±׸� */
	@Persistent
	private String name;

	// method ------------------------------------------------------------------
	public ContentTag(String tagName) {
		this.name = tagName;
	}
	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
