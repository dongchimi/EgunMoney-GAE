package com.appspot.egunmoney.domain;

/** 
 * �̰ǸӴϿ� ���� ������ ����
 * @author dklee
 * @since 2010.09.01
 *
 */
public enum EgunAuthorize {
	READ("�б�"),
	WRITE("����"),
	READ_WRITE("�а� ����");
	
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
