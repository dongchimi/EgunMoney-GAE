package com.appspot.egunmoney.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.appspot.egunmoney.utility.CollectionUtil;

public class AccountBookCategoryGroup implements Serializable{
	
	/** UID */
	private static final long serialVersionUID = 1970970654340276984L;
	
	/** 분류목록 */
	private List<Category> categories;

	/** 정렬된 카테고리 조회 */
	public List<Category> getSortedCategories() {
		if (CollectionUtil.isEmpty(categories)) return new ArrayList<Category>();
		
		Collections.sort(categories);
		for (Category category : categories) {
			if (category.hasSubCategories()) {
				category.sortingSubCategories();
			}
		}
		
		return categories;
	}
	
	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

}
