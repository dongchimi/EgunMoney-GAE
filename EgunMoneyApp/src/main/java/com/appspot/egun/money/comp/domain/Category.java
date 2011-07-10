package com.appspot.egun.money.comp.domain;

import java.io.Serializable;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * �з� ��) �ĺ�, �ְ����...
 * 
 * @author dklee
 * @since 2011.07.10
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Category implements Serializable {

	/** UID */
	private static final long serialVersionUID = 78595356383234132L;

	/** ������Ʈ id */
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long oid;

	/** �з� �� */
	@Persistent
	private String name;
	
	/** �з� �� */
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