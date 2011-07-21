package com.appspot.egun.money.comp.service;

import java.util.List;

import com.appspot.egun.money.comp.domain.Authorize;
import com.appspot.egun.money.comp.domain.EgunUser;
import com.appspot.egun.money.comp.domain.MoneyBook;
import com.appspot.egun.money.comp.domain.MoneyBookAuthorize;

/**
 * ����� Sheet ����
 * @author dklee
 * @since 2010.09.03
 *
 */
public interface MoneyBookService
{
    /**
     * ��� ���
     * @param book
     * @return
     */
    public Long reigsterMoneyBook( MoneyBook book );

    /**
     * ������� �⺻ ��� ��ȸ
     * @param userEmail ����� �̸���
     * @return ��� 
     */
    public MoneyBook findDefaultMoneyBookByUserEmail( String userEmail );

    /**
     * ����� ���� �ο�
     * @param authorize
     * @return
     */
    public Long registerMoneyBookAuthorize( MoneyBookAuthorize authorize );

    /**
     * ����� ���� Ȯ��
     * @param user
     * @param book
     * @return
     */
    public boolean hasMoneyBookAuthorize( EgunUser user, MoneyBook book );

    /**
     * �ش��ϴ� ���� ��� ��ȸ
     * @param userEmail ����� email
     * @param authorizes ���Ѹ��
     * @return ����� email�� �ʿ��� ���ѿ� �ش��ϴ� ��� ��ȸ
     */
    public List<MoneyBookAuthorize> findMoneyBookAuthorizeByUserEmail( String userEmail,
                                                                           List<Authorize> authorizes );

    /**
     * id�� �ش��ϴ� ����� ��ȸ
     * @param bookId
     * @return �����
     */
    public MoneyBook getMoneyBook( long bookId );
}
