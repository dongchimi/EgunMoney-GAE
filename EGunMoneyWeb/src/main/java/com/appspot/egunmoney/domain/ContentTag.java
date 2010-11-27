package com.appspot.egunmoney.domain;

import java.io.Serializable;

/**
 * 태그
 * 예) @죽녹원여행
 * @author dklee
 * @since 2010.09.01
 */
public class ContentTag implements Serializable{
	
	/** UID */
	private static final long serialVersionUID = -9165491965093509365L;

	/** 오브젝트 id */
	private int oid;

	/** 태그명 */
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
