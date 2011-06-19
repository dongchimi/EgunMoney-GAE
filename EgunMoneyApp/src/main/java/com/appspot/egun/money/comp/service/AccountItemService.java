package com.appspot.egun.money.comp.service;

import java.util.List;

import com.appspot.egun.money.comp.domain.AccountItem;

/**
 * ����� Item ����
 * @author dklee
 * @since 2010.09.03
 *
 */
public interface AccountItemService
{
    /**
     * ��� item ���
     * @param item ��� item
     * @return item Ű
     */
    public Long registerAccountBookItem( AccountItem item );

    /**
     * �Ⱓ���� ��� ����� ��ȸ
     * @param bookId ��� id
     * @param startDay ��������
     * @param endDay �������� 
     * @return
     */
    public List<AccountItem> findAccountItemsByTerm( long bookId, String startDay, String endDay );
}
