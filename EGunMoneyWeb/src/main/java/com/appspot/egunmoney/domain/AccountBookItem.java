package com.appspot.egunmoney.domain;

import java.io.Serializable;
import java.util.List;

/**
 * ����� item
 * ��) 2010.09.01. Ŀ������ 1,000��
 * @author dklee
 * @since 2010.09.01
 *
 */
public class AccountBookItem implements Serializable{
	
	/** UID */
	private static final long serialVersionUID = 9068836291602127173L;

	/** ����*/
	private long itemId;
	
	/** ��¥ */
	private String date;
	
	/** �ݾ� */
	private long amount;
	
	/** ���� */
	private String content;
	
	/** ��� */
	private String description;
	
	/** �±׸�� */
	private List<ContentTag> tags;
	
	// method ------------------------------------------------------------------
	
	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ContentTag> getTags() {
		return tags;
	}

	public void setTags(List<ContentTag> tags) {
		this.tags = tags;
	}

	
}
