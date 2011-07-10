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
}
