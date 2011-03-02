package com.appspot.egun.money.comp.domain;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

/**
 * 예산부 item
 * @author dklee
 * @since 2010.09.01
 */
@PersistenceCapable(identityType=IdentityType.DATASTORE)
public class BudgetBookItem {
	
	/** 오브젝트 id */
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key oid;
	
	/** 카테고리명 */
	@Persistent
	private String categoryName;
	
	/** 예산금액 */
	@Persistent
	private long budgetAmount;
	
	/** 예산부*/
	@Persistent(defaultFetchGroup="true")
	private BudgetBook budgetBook;
	
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

	public Key getOid() {
		return oid;
	}

	public void setOid(Key oid) {
		this.oid = oid;
	}

	public BudgetBook getBudgetBook() {
		return budgetBook;
	}

	public void setBudgetBook(BudgetBook budgetBook) {
		this.budgetBook = budgetBook;
	}
}
