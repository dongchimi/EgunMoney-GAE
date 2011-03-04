package com.appspot.egun.money.comp.domain;

import java.text.DecimalFormat;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.appspot.egun.money.comp.constant.EgunMoneyConstant;
import com.appspot.egun.money.comp.utility.SU;

/**
 * �̰ǸӴ� �����
 * @author dklee
 * @since 2010.09.01
 */
@PersistenceCapable(identityType=IdentityType.APPLICATION)
public class AccountBook {
	
	/** ������Ʈ id */
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long oid;

	/** ����� �� */
	@Persistent
	private String accountBookName;
	
	/** ������ */
	@Persistent
	private String baseDay;
	
	/** ����� */
//	@Persistent(mappedBy="egunAccountBook")
//	private BudgetBook budgetBook;
	
	@Persistent
	private String ownerId;
	
	// method ------------------------------------------------------------------
	public AccountBook(EgunUser user) {
		initialize(user, null);
	}
	
	public AccountBook(EgunUser user, String bookName) {
		initialize(user, bookName);
	}
	
	private void initialize(EgunUser user, String bookName) {
		ownerId = user.getUserEmail();
		if (SU.isEmptyOrNull(bookName)) {
			accountBookName = user.getNickName() + "���� �����";
		} else {
			accountBookName = bookName;
		}
 		baseDay = EgunMoneyConstant.INITIAL_BASE_DATE;
		
		// �̹��� ������ ����
		//budgetBook = new BudgetBook(baseDay);
	}
	
	public String getBaseDay() {
		return baseDay;
	}

	public void setBaseDay(String baseDay) {
		DecimalFormat df = new DecimalFormat("00");
		this.baseDay = df.format(baseDay);
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
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
