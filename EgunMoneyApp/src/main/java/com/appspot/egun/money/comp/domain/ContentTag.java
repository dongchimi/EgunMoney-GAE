package com.appspot.egun.money.comp.domain;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * 태그
 * 예) @죽녹원여행
 * @author dklee
 * @since 2010.09.01
 */
@PersistenceCapable
public class ContentTag {
	
	/** 오브젝트 id */
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long oid;

	/** 태그명 */
	@Persistent
	private String name;
	
	// method ------------------------------------------------------------------
	public static List<ContentTag> getTagString(String tagString) {
		List<ContentTag> tags = new ArrayList<ContentTag>();
		if (tagString == null || tagString.length() < 1) return tags;
		
		String[] tagStrings = tagString.split("/,");
		for(String tag : tagStrings) {
			ContentTag contentTag = new ContentTag(tag);
			tags.add(contentTag);
		}
		
		return tags;
	}
	
	public ContentTag(String tagName) {
		this.name = tagName;
	}
	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
