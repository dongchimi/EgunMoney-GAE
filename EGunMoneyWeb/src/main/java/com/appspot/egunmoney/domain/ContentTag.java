package com.appspot.egunmoney.domain;

/**
 * 태그
 * 예) @죽녹원여행
 * @author dklee
 * @since 2010.09.01
 */
public class ContentTag {
	
	/** 오브젝트 id */
	private int oid;
	
	// method ------------------------------------------------------------------
	
	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	/** 태그명 */
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
