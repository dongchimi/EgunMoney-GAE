package com.appspot.egunmoney.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.appspot.egunmoney.utility.CollectionUtil;

public class AccountBookCategoryGroup {
	
	/** �з���� */
	private List<Category> categories;

	/** ���ĵ� ī�װ� ��ȸ */
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
