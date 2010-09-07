package com.appspot.egunmoney.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 가계부 item
 * 예) 2010.09.01. 커피한잔 1,000원
 * @author dklee
 * @since 2010.09.01
 *
 */
public class AccountBookItem implements Serializable{
	
	/** UID */
	private static final long serialVersionUID = 9068836291602127173L;

	/** 내용*/
	private long itemId;
	
	/** 날짜 */
	private String date;
	
	/** 금액 */
	private long amount;
	
	/** 내역 */
	private String content;
	
	/** 비고 */
	private String description;
	
	/** 태그목록 */
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
