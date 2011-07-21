package com.appspot.egun.money.comp.domain;

/**
 * 기본 자산 유형
 * @author dongkyu
 * @since	2011.07.22
 */
public enum DefaultAssetType {
	/** 지갑 */
	WALLET,
	/** 카드 */
	CARD,
	/** 일반계좌*/
	BANK_ACCOUNT,
	/** 대출계좌 */
	LOAN_ACCOUNT,
	/** 보험 */
	INSURANCE,
	/** 적금 */
	INSTALLMENT_SAVING_ACCOUNT;
}
