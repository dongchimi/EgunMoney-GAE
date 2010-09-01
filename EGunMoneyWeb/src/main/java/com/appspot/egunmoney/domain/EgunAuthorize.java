package com.appspot.egunmoney.domain;

/** 
 * 이건머니에 적용 가능한 권한
 * @author dklee
 * @since 2010.09.01
 *
 */
public enum EgunAuthorize {
	READ("읽기"),
	WRITE("쓰기"),
	READ_WRITE("읽고 쓰기");
	
	private String krName;
	
	private EgunAuthorize(String krName) {
		this.krName = krName;
	}

	public String getKrName() {
		return krName;
	}

	public void setKrName(String krName) {
		this.krName = krName;
	}
	
	
}
