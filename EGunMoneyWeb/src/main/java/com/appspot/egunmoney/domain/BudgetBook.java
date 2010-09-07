package com.appspot.egunmoney.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 예산부
 * @author dklee
 * @since 2010.09.01
 */
public class BudgetBook implements Serializable{
	
	/** UID */
	private static final long serialVersionUID = 875775556113822889L;
	/** 예산부 내역 목록 */
	private List<BudgetBookItem> budgetBookItems;

	// method ------------------------------------------------------------------
	
	public List<BudgetBookItem> getBudgetBookItems() {
		return budgetBookItems;
	}

	public void setBudgetBookItems(List<BudgetBookItem> budgetBookItems) {
		this.budgetBookItems = budgetBookItems;
	}
}
