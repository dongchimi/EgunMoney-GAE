package com.appspot.egun.money.domain;

import java.text.DecimalFormat;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.appspot.egun.money.constant.EgunMoneyConstant;
import com.google.appengine.api.datastore.Key;

/**
 * 이건머니 가계부
 * @author dklee
 * @since 2010.09.01
 */
@PersistenceCapable(identityType=IdentityType.DATASTORE)
public class EgunAccountBook {
	
	/** 오브젝트 id */
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key oid;

	/** 가계부 명 */
	@Persistent
	private String accountBookName;
	
	/** 기준일 */
	@Persistent
	private String baseDay;
	
	/** 장부 내역목록 */
//	@Persistent(mappedBy="egunAccountBook")
//	private List<AccountBookItem> accountBookItems;
	
	/** 예산부 */
	@Persistent(mappedBy="egunAccountBook")
	private BudgetBook budgetBook;
	
	/** 가계부 분류 */
//	@Persistent(mappedBy="egunAccountBook")
//	private AccountBookCategoryGroup categoryGroup;
	
	@Persistent
	private String ownerId;
	
	// method ------------------------------------------------------------------
	public EgunAccountBook(EgunUser user) {
		ownerId = user.getUserEmail();
		accountBookName = user.getNickName() + "님의 가계부";
 		baseDay = EgunMoneyConstant.INITIAL_BASE_DATE;
		
		// 이번달 예산을 만듦
		budgetBook = new BudgetBook(baseDay);
	}
	
	public String getBaseDay() {
		return baseDay;
	}

	public void setBaseDay(String baseDay) {
		DecimalFormat df = new DecimalFormat("00");
		this.baseDay = df.format(baseDay);
	}

	public Key getOid() {
		return oid;
	}

	public void setOid(Key oid) {
		this.oid = oid;
	}
//	public AccountBookCategoryGroup getCategoryGroup() {
//	return categoryGroup;
//}
//
//public void setCategoryGroup(AccountBookCategoryGroup categoryGroup) {
//	this.categoryGroup = categoryGroup;
//}
	
//	public List<AccountBookItem> getAccountBookItems() {
//		return accountBookItems;
//	}
//
//	public void setAccountBookItems(List<AccountBookItem> accountBookItems) {
//		this.accountBookItems = accountBookItems;
//	}

	public BudgetBook getBudgetBook() {
		return budgetBook;
	}

	public void setBudgetBook(BudgetBook budgetBook) {
		this.budgetBook = budgetBook;
	}

	public String getAccountBookName() {
		return accountBookName;
	}

	public void setAccountBookName(String accountBookName) {
		this.accountBookName = accountBookName;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
}
