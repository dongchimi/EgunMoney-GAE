package com.appspot.egun.money.comp.domain;

/**
 * �̰ǸӴϿ� ���� ������ ����
 * 
 * @author dklee
 * @since 2010.09.01
 */
public enum Authorize {
	READ("�б�"), READ_WRITE("�а� ����");

	private String krName;

	private Authorize(String krName) {
		this.krName = krName;
	}

	public String getKrName() {
		return krName;
	}

	public void setKrName(String krName) {
		this.krName = krName;
	}
}
