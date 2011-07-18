package com.appspot.egun.money.comp.domain;

/**
 * 수입/지출/이체 구분
 * 
 * @author dongchimi
 * @since 2011.07.10
 */
public enum InOutTransfer {
	IN("수입"), OUT("지출"), TRANSFER("이체");

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
