package com.appspot.egun.money.comp.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * 태그 예) @죽녹원여행
 * 
 * @author dklee
 * @since 2010.09.01
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class EgunTag implements Serializable {

	/** UID */
	private static final long serialVersionUID = 79134734938521283L;

	/** 오브젝트 id */
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long oid;

	/** 태그명 */
	@Persistent
	private String name;

	// method ------------------------------------------------------------------
	/**
	 * ,을 포함한 관련어 문자열을 List형태로 반환
	 * @param tagString
	 * @return
	 */
	public static List<EgunTag> getTagString(String tagString) {
		List<EgunTag> tags = new ArrayList<EgunTag>();
		if (tagString == null || tagString.length() < 1)
			return tags;

		String[] tagStrings = tagString.split("/,");
		for (String tag : tagStrings) {
			EgunTag contentTag = new EgunTag(tag);
			tags.add(contentTag);
		}

		return tags;
	}

	public EgunTag(String tagName) {
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
