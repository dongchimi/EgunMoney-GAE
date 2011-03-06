package com.appspot.egun.money.comp.service;

import java.util.List;

import com.appspot.egun.money.comp.domain.ContentTag;

/**
 * 태그 서비스 
 * @author dongchimi
 * @since 2011.03.06
 *
 */
public interface ContentTagService {
	
	/**
	 * 태그 등록
	 * @param tag
	 * @return
	 */
	public Long registerContentTag(ContentTag tag);
	
	/**
	 * 태그 목록 등록
	 * @param tags
	 */
	public List<Long> registerContentTags(List<ContentTag> tags);
}
