package com.appspot.egunmoney.domain;

import java.util.List;

/**
 * �����
 * @author dklee
 * @since 2010.09.01
 */
public class BudgetBook {
	
	/** ����� ���� ��� */
	private List<BudgetBookItem> budgetBookItems;

	// method ------------------------------------------------------------------
	
	public List<BudgetBookItem> getBudgetBookItems() {
		return budgetBookItems;
	}

	public void setBudgetBookItems(List<BudgetBookItem> budgetBookItems) {
		this.budgetBookItems = budgetBookItems;
	}
}
