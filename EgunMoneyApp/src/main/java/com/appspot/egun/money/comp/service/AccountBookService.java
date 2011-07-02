package com.appspot.egun.money.comp.service;

import java.util.List;

import com.appspot.egun.money.comp.domain.AccountBook;
import com.appspot.egun.money.comp.domain.AccountBookAuthorize;
import com.appspot.egun.money.comp.domain.EgunAuthorize;
import com.appspot.egun.money.comp.domain.EgunUser;

/**
 * ����� Sheet ����
 * @author dklee
 * @since 2010.09.03
 *
 */
public interface AccountBookService
{
    /**
     * ��� ���
     * @param book
     * @return
     */
    public Long reigsterAccountBook( AccountBook book );

    /**
     * ������� �⺻ ��� ��ȸ
     * @param userEmail ����� �̸���
     * @return ��� 
     */
    public AccountBook findDefaultAccountBookByUserEmail( String userEmail );

    /**
     * ����� ���� �ο�
     * @param authorize
     * @return
     */
    public Long registerAccountBookAuthorize( AccountBookAuthorize authorize );

    /**
     * ����� ���� Ȯ��
     * @param user
     * @param book
     * @return
     */
    public boolean hasAccountBookAuthorize( EgunUser user, AccountBook book );

    /**
     * �ش��ϴ� ���� ��� ��ȸ
     * @param userEmail ����� email
     * @param authorizes ���Ѹ��
     * @return ����� email�� �ʿ��� ���ѿ� �ش��ϴ� ��� ��ȸ
     */
    public List<AccountBookAuthorize> findAccountBookAuthorizeByUserEmail( String userEmail,
                                                                           List<EgunAuthorize> authorizes );

    /**
     * id�� �ش��ϴ� ����� ��ȸ
     * @param bookId
     * @return �����
     */
    public AccountBook getAccountBook( long bookId );
}
