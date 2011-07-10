package com.appspot.egun.money.comp.domain;

/**
 * 수입/지출 구분
 * 
 * @author dongchimi
 * @since 2011.07.10
 */
public enum InOut {
	IN("수입"), OUT("지출");

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
