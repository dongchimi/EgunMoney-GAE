package com.appspot.egun.money.comp.domain;

/**
 * ����/����/��ü ����
 * 
 * @author dongchimi
 * @since 2011.07.10
 */
public enum InOutTransfer {
	IN("����"), OUT("����"), TRANSFER("��ü");

	private String korean;

	private InOutTransfer(String korean) {
		this.korean = korean;
	}

	public String getKorean() {
		return korean;
	}

	public void setKorean(String korean) {
		this.korean = korean;
	}
}
