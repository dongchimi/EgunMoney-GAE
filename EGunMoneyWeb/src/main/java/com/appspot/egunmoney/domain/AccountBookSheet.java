package com.appspot.egunmoney.domain;

import java.util.List;

/**
 * 장부
 * 예) 7~8월 장부
 * @author dklee
 * @since 2010.09.01
 */
public class AccountBookSheet {
	
	/** 시작일 */
	private String startDate;
	
	/** 종료일 */
	private String endDate;
	
	/** 장부 내역목록 */
	private List<AccountBookItem> accountBookItems;
	
	/** 예산부 */
	private BudgetBook budgetBook;
	
	// method ------------------------------------------------------------------

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public List<AccountBookItem> getAccountBookItems() {
		return accountBookItems;
	}

	public void setAccountBookItems(List<AccountBookItem> accountBookItems) {
		this.accountBookItems = accountBookItems;
	}

	public BudgetBook getBudgetBook() {
		return budgetBook;
	}

	public void setBudgetBook(BudgetBook budgetBook) {
		this.budgetBook = budgetBook;
	}
}
