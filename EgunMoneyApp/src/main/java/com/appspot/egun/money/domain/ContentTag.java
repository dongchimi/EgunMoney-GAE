package com.appspot.egun.money.domain;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * 태그
 * 예) @죽녹원여행
 * @author dklee
 * @since 2010.09.01
 */
@PersistenceCapable
public class ContentTag {
	
	/** 오브젝트 id */
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private int oid;

	/** 태그명 */
	@Persistent
	private String name;
	
	@Persistent
	private AccountBookItem accountBookItem;

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
	public AccountBookItem getAccountBookItem() {
		return accountBookItem;
	}
	public void setAccountBookItem(AccountBookItem accountBookItem) {
		this.accountBookItem = accountBookItem;
	}
}
