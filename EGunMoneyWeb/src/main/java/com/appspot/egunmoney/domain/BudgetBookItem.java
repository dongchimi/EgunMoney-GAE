package com.appspot.egunmoney.domain;

import java.io.Serializable;


/**
 * ����� item
 * @author dklee
 * @since 2010.09.01
 */
public class BudgetBookItem implements Serializable{
	
	/** UID */
	private static final long serialVersionUID = 6063459783628670236L;

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
