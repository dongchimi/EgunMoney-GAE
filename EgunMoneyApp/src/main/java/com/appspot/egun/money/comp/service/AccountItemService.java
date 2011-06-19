package com.appspot.egun.money.comp.service;

import java.util.List;

import com.appspot.egun.money.comp.domain.AccountItem;

/**
 * 가계부 Item 서비스
 * @author dklee
 * @since 2010.09.03
 *
 */
public interface AccountItemService
{
    /**
     * 장부 item 등록
     * @param item 장부 item
     * @return item 키
     */
    public Long registerAccountBookItem( AccountItem item );

    /**
     * 기간내의 장부 목록을 조회
     * @param bookId 장부 id
     * @param startDay 시작일자
     * @param endDay 종ㄹ일자 
     * @return
     */
    public List<AccountItem> findAccountItemsByTerm( long bookId, String startDay, String endDay );
}
