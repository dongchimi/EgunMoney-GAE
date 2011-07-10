package com.appspot.egun.money.comp.domain;

/**
 * ����/���� ����
 * 
 * @author dongchimi
 * @since 2011.07.10
 */
public enum InOut {
	IN("����"), OUT("����");

	private String korean;

	private InOut(String korean) {
		this.korean = korean;
	}

	public String getKorean() {
		return korean;
	}

	public void setKorean(String korean) {
		this.korean = korean;
	}
}
