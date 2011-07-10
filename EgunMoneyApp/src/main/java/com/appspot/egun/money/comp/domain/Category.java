package com.appspot.egun.money.comp.domain;

import java.io.Serializable;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * 분류 예) 식비, 주거통신...
 * 
 * @author dklee
 * @since 2011.07.10
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Category implements Serializable {

	/** UID */
	private static final long serialVersionUID = 78595356383234132L;

	/** 오브젝트 id */
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long oid;

	/** 분류 명 */
	@Persistent
	private String name;
	
	/** 분류 상세 */
	@Persistent
	private List<DetailCategory> detailCategries;
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

	public List<DetailCategory> getDetailCategries() {
		return detailCategries;
	}

	public void setDetailCategries(List<DetailCategory> detailCategries) {
		this.detailCategries = detailCategries;
	}
}