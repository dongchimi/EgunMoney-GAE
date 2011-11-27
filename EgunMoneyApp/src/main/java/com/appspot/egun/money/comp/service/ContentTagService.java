package com.appspot.egun.money.comp.service;

import java.util.List;

import com.appspot.egun.money.comp.domain.EgunTag;

/**
 * �±� ���� 
 * @author dongchimi
 * @since 2011.03.06
 *
 */
public interface ContentTagService
{
    /**
     * �±� ���
     * @param tag
     * @return
     */
    public Long registerContentTag( EgunTag tag );

    /**
     * �±� ��� ���
     * @param tags
     */
    public List<Long> registerContentTags( List<EgunTag> tags );
    
    /**
     * �̸����� �±� ��ȸ
     * @param tagName
     * @return
     */
    public EgunTag getContentTagByName(String tagName);
    
    /**
     * oid�� �±� ��ȸ
     * @param tagOids
     * @return
     */
	public List<EgunTag> findEgunTagsByOid(List<Long> tagOids);
	
	/**
	 * ������� �±��ΰ�?
	 * @param tagOid
	 * @param exceptBookItem
	 * @return
	 */
	public boolean isUsingEgunTag(Long tagOid, Long exceptBookItem);
	
	/**
	 * �±� ����
	 * @param tagOid
	 */
	public void removeEgunTag(Long tagOid);
}
