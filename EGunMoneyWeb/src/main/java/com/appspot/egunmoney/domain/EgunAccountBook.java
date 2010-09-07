package com.appspot.egunmoney.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 이건머니 가계부
 * @author dklee
 * @since 2010.09.01
 *
 */
public class EgunAccountBook implements Serializable{
	
	/** 오브젝트 id */
	private long oId;

	/** 가계부 명 */
	private String name;
	
	/** 기준일 */
	private String baseDay;
	
	/** 장부 목록 */
	private List<AccountBookSheet> bookSheets;
	
	/** 가계부 분류 */
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
