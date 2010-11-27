package com.appspot.egunmoney.domain;

import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

/**
 * 가계부 item
 * @author dklee
 * @since 2010.09.01
 */
@PersistenceCapable
public class AccountBookItem{
	
	/** id*/
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key oId;
	
	/** 날짜 */
	@Persistent
	private String useDate;

	/** 금액 */
	@Persistent
	private long amount;
	
	/** 비고 */
	@Persistent
	private String description;
	
	/** 카테고리 */
	@Persistent
	private Category category;
	
	/** 태그목록 */
	@Persistent
	private List<ContentTag> tags;
	
	// method ------------------------------------------------------------------
	public String getMyCategoryName() {
		if (category == null) return null;
		
		return category.getCategoryName();
	}
	
	public void setTagString(String tagString) {
		if (tagString == null || tagString.length() < 1) return;
		
		String[] tagStrings = tagString.split("/,");
		for(String tag : tagStrings) {
			ContentTag contentTag = new ContentTag(tag);
			tags.add(contentTag);
		}
	}
	
	public String getTagString() {
		if (tags == null || tags.size() == 0) return "";
		
		StringBuilder tagBuilder = new StringBuilder();
		for(ContentTag tag : tags) {
			tagBuilder.append(tag.getName()).append(", ");
		}
		
		return tagBuilder.toString();
	}
	
	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
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
	
	public String getUseDate() {
		return useDate;
	}

	public void setUseDate(String useDate) {
		this.useDate = useDate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Key getoId() {
		return oId;
	}

	public void setoId(Key oId) {
		this.oId = oId;
	}
}
