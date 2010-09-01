package com.appspot.egunmoney.domain;


/**
 * 예산부 item
 * @author dklee
 * @since 2010.09.01
 */
public class BudgetBookItem {
	
	/** 오브젝트 id */
	private long oid;
	
	/** 카테고리명 */
	private String categoryName;
	
	/** 예산금액 */
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
