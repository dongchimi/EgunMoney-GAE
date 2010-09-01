package com.appspot.egunmoney.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.appspot.egunmoney.utility.CollectionUtil;

/**
 * 분류
 * 예) 식비, 주거통신...
 * @author dklee
 * @since 2010.09.01
 */
public class Category implements Comparable<Category> {
	
	/** 오브젝트 id */
	private long oid;
	
	/** 순서 (화면에서 사용) */
	private int order;
	
	/** 순위 대, 중, 소분류를 결정 */
	private int depth;
	
	/** 카테고리 명 */
	private String name;
	
	/** 하위 카테고리 */
	private List<Category> subCategories;
	
	// method ------------------------------------------------------------------
	
	/** 하위 카테고리 정렬 */
	public List<Category> sortingSubCategories() {
		if (CollectionUtil.isEmpty(subCategories)) return new ArrayList<Category>();
		
		Collections.sort(subCategories);
		for (Category category : subCategories) {
			if (category.hasSubCategories()) {
				category.sortingSubCategories();
			}
		}
		return subCategories;
	}
	
	public boolean hasSubCategories() {
		if (subCategories == null && !subCategories.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	public long getOid() {
		return oid;
	}
	public void setOid(long oid) {
		this.oid = oid;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Category> getSubCategories() {
		return subCategories;
	}
	public void setSubCategories(List<Category> subCategories) {
		this.subCategories = subCategories;
	}
	
	@Override
	public int compareTo(Category o) {
		if (order > o.getOrder()) return 1;
		if (order < o.getOrder()) return -1;
		
		return 0;
	}
}