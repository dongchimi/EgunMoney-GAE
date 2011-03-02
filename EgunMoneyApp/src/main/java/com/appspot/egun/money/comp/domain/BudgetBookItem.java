package com.appspot.egun.money.comp.domain;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

/**
 * ����� item
 * @author dklee
 * @since 2010.09.01
 */
@PersistenceCapable(identityType=IdentityType.DATASTORE)
public class BudgetBookItem {
	
	/** ������Ʈ id */
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key oid;
	
	/** ī�װ��� */
	@Persistent
	private String categoryName;
	
	/** ����ݾ� */
	@Persistent
	private long budgetAmount;
	
	/** �����*/
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
