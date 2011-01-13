package com.appspot.egunmoney.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import com.appspot.egunmoney.utility.CU;
import com.google.appengine.api.datastore.Key;

/**
 * �з�
 * ��) �ĺ�, �ְ����...
 * @author dklee
 * @since 2010.09.01
 */
@PersistenceCapable
public class Category implements Comparable<Category> {
	
	/** ������Ʈ id */
	@Persistent
	private Key oid;
	
	/** ���� (ȭ�鿡�� ���) */
	@Persistent
	private int order;
	
	/** ���� ��, ��, �Һз��� ���� */
	@Persistent
	private int depth;
	
	/** ī�װ� �� */
	@Persistent
	private String name;
	
	/** ���� ī�װ� */
	@Persistent(mappedBy="parentCategory")
	private List<Category> subCategories;
	
	@Persistent
	private Category parentCategory;
	// method ------------------------------------------------------------------
	/**
	 * ���� ī�װ� �� �� �����Ͽ� ��ȸ<br />
	 * ��) �ĺ� > �ֽ�
	 */
	public String getCategoryName() {
		StringBuilder nameBuilder = new StringBuilder();
		
		nameBuilder.append(name);
		if (subCategories != null) {
			for (Category subCategory : subCategories) {
				nameBuilder.append(" > ").append(subCategory.getName());
			}
		}
		return nameBuilder.toString();
	}
	
	/** ���� ī�װ� ���� */
	public List<Category> sortingSubCategories() {
		if (CU.isEmpty(subCategories)) return new ArrayList<Category>();
		
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
	public Key getOid() {
		return oid;
	}
	public void setOid(Key oid) {
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

	public Category getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}
}