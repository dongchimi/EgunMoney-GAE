package com.appspot.egunmoney.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.appspot.egunmoney.utility.CollectionUtil;

/**
 * �з�
 * ��) �ĺ�, �ְ����...
 * @author dklee
 * @since 2010.09.01
 */
public class Category implements Comparable<Category> {
	
	/** ������Ʈ id */
	private long oid;
	
	/** ���� (ȭ�鿡�� ���) */
	private int order;
	
	/** ���� ��, ��, �Һз��� ���� */
	private int depth;
	
	/** ī�װ� �� */
	private String name;
	
	/** ���� ī�װ� */
	private List<Category> subCategories;
	
	// method ------------------------------------------------------------------
	
	/** ���� ī�װ� ���� */
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