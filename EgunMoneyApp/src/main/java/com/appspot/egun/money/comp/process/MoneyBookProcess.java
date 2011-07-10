package com.appspot.egun.money.comp.process;

import java.util.List;

import com.appspot.egun.money.comp.domain.MoneyBook;
import com.appspot.egun.money.comp.domain.MoneyBookAuthorize;
import com.appspot.egun.money.comp.domain.EgunUser;

public interface MoneyBookProcess
{
    /**
     * ��� ���
     * @param book
     * @return
     */
    public Long reigsterMoneyBook( MoneyBook book );

    /**
     * ������� ��� ��� ��ȸ
     * @param userEmail ����� �̸���
     * @return ��� ���
     */
    public List<MoneyBook> findMoneyBookByUserEmail( String userEmail );

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
}
