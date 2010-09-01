package com.appspot.egunmoney.domain;

import java.util.List;

/**
 * ���
 * ��) 7~8�� ���
 * @author dklee
 * @since 2010.09.01
 */
public class AccountBookSheet {
	
	/** ������ */
	private String startDate;
	
	/** ������ */
	private String endDate;
	
	/** ��� ������� */
	private List<AccountBookItem> accountBookItems;
	
	/** ����� */
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
