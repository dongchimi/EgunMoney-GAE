package com.appspot.egun.money.domain;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.appspot.egun.money.utility.DU;
import com.google.appengine.api.datastore.Key;

/**
 * �����
 * @author dklee
 * @since 2010.09.01
 */
@PersistenceCapable(identityType=IdentityType.DATASTORE)
public class BudgetBook {
	
	/** ������Ʈ id */
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key oid;
	
	/** ����� ���� ��� */
	@Persistent
	private List<BudgetBookItem> budgetBookItems;

	@Persistent(defaultFetchGroup="false")
	private EgunAccountBook egunAccountBook;

	@Persistent
	private String startDate;
	
	@Persistent
	private String endDate;
	
	// method ------------------------------------------------------------------
	public BudgetBook(String baseDay) {
		String thisDate = DU.getCurrentDateString();
		String baseDate = thisDate.substring(0, 6) + baseDay;
		
		if (DU.isAfterDate(baseDate)) {
			startDate = baseDate;
			endDate = DU.addDate( DU.addMonth(baseDate, 1), -1);
		} else {
			startDate = DU.addMonth(baseDate, -1);
			endDate = DU.addDate( baseDate, -1);
		}

		// �ӽ÷� �߰�
		BudgetBookItem item = new BudgetBookItem();
		item.setBudgetAmount(40000);
		item.setCategoryName("ī�װ���");
		addBudgetBookItem(item);
	}
	
	public void addBudgetBookItem(BudgetBookItem item) {
		if (budgetBookItems == null) {
			budgetBookItems = new ArrayList<BudgetBookItem>();
		}
		
		budgetBookItems.add(item);
	}
	
	public List<BudgetBookItem> getBudgetBookItems() {
		return budgetBookItems;
	}

	public void setBudgetBookItems(List<BudgetBookItem> budgetBookItems) {
		this.budgetBookItems = budgetBookItems;
	}

	public EgunAccountBook getEgunAccountBook() {
		return egunAccountBook;
	}

	public void setEgunAccountBook(EgunAccountBook egunAccountBook) {
		this.egunAccountBook = egunAccountBook;
	}

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

	public Key getOid() {
		return oid;
	}

	public void setOid(Key oid) {
		this.oid = oid;
	}
}
