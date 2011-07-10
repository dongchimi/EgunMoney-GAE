package com.appspot.egun.money.comp.domain;

import java.io.Serializable;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

/**
 * 분류 예) 식비, 주거통신...
 * 
 * @author dklee
 * @since 2011.07.10
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class DetailCategory implements Serializable {

	/** UID */
	private static final long serialVersionUID = 78595356383234132L;

	/** 오브젝트 id */
	@Persistent
	private Long oid;

	/** 카테고리 명 */
	@Persistent
	private String name;

	// method ------------------------------------------------------------------

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
}