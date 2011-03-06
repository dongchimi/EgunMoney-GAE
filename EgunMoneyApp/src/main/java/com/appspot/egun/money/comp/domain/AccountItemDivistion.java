package com.appspot.egun.money.comp.domain;

/**
 * ����/���� ����
 * @author dongchimi
 */
public enum AccountItemDivistion {
	IN("����"),
	OUT("����");
	
	private String korean;
	
	private AccountItemDivistion(String korean) {
		this.korean = korean;
	}

	public String getKorean() {
		return korean;
	}

	public void setKorean(String korean) {
		this.korean = korean;
	}
}
