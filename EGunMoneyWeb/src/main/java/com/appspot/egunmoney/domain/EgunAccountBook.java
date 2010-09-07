package com.appspot.egunmoney.domain;

import java.io.Serializable;
import java.util.List;

/**
 * �̰ǸӴ� �����
 * @author dklee
 * @since 2010.09.01
 *
 */
public class EgunAccountBook implements Serializable{
	
	/** ������Ʈ id */
	private long oId;

	/** ����� �� */
	private String name;
	
	/** ������ */
	private String baseDay;
	
	/** ��� ��� */
	private List<AccountBookSheet> bookSheets;
	
	/** ����� �з� */
	private AccountBookCategoryGroup categoryGroup;
	
	// method ------------------------------------------------------------------
	
	public AccountBookCategoryGroup getCategoryGroup() {
		return categoryGroup;
	}

	public void setCategoryGroup(AccountBookCategoryGroup categoryGroup) {
		this.categoryGroup = categoryGroup;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AccountBookSheet> getBookSheets() {
		return bookSheets;
	}

	public void setBookSheets(List<AccountBookSheet> bookSheets) {
		this.bookSheets = bookSheets;
	}

	public String getBaseDay() {
		return baseDay;
	}

	public void setBaseDay(String baseDay) {
		this.baseDay = baseDay;
	}

	public long getoId() {
		return oId;
	}

	public void setoId(long oId) {
		this.oId = oId;
	}
}
