package com.appspot.egunmoney.domain;

import java.io.Serializable;

/**
 * �±�
 * ��) @�׳������
 * @author dklee
 * @since 2010.09.01
 */
public class ContentTag implements Serializable{
	
	/** ������Ʈ id */
	private int oid;
	
	// method ------------------------------------------------------------------
	
	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	/** �±׸� */
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
