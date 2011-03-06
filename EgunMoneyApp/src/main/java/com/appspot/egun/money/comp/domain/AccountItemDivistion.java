package com.appspot.egun.money.comp.domain;

/**
 * 수입/지출 구분
 * @author dongchimi
 */
public enum AccountItemDivistion {
	IN("수입"),
	OUT("지출");
	
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
