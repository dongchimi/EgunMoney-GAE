package com.appspot.egunmoney.domain;


/**
 * ����� item
 * @author dklee
 * @since 2010.09.01
 */
public class BudgetBookItem {
	
	/** ������Ʈ id */
	private long oid;
	
	/** ī�װ��� */
	private String categoryName;
	
	/** ����ݾ� */
	private long budgetAmount;
	
	// method ------------------------------------------------------------------

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public long getBudgetAmount() {
		return budgetAmount;
	}

	public void setBudgetAmount(long budgetAmount) {
		this.budgetAmount = budgetAmount;
	}

	public long getOid() {
		return oid;
	}

	public void setOid(long oid) {
		this.oid = oid;
	}
}
