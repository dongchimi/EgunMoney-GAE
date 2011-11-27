package com.appspot.egun.money.comp.service;

import java.util.List;

import com.appspot.egun.money.comp.domain.EgunTag;

/**
 * 태그 서비스 
 * @author dongchimi
 * @since 2011.03.06
 *
 */
public interface ContentTagService
{
    /**
     * 태그 등록
     * @param tag
     * @return
     */
    public Long registerContentTag( EgunTag tag );

    /**
     * 태그 목록 등록
     * @param tags
     */
    public List<Long> registerContentTags( List<EgunTag> tags );
    
    /**
     * 이름으로 태그 조회
     * @param tagName
     * @return
     */
    public EgunTag getContentTagByName(String tagName);
    
    /**
     * oid로 태그 조회
     * @param tagOids
     * @return
     */
	public List<EgunTag> findEgunTagsByOid(List<Long> tagOids);
	
	/**
	 * 사용중인 태그인가?
	 * @param tagOid
	 * @param exceptBookItem
	 * @return
	 */
	public boolean isUsingEgunTag(Long tagOid, Long exceptBookItem);
	
	/**
	 * 태그 삭제
	 * @param tagOid
	 */
	public void removeEgunTag(Long tagOid);
}
