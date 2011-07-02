package com.appspot.egun.money.comp.service;

import com.appspot.egun.money.comp.domain.AccountBook;

/**
 * �̰ǸӴ� ����� ����
 * @author dklee
 * @since 2010.09.03
 */
public interface EgunAccountBookService
{
    /**
     * ����� ����
     * @param accountBook �����
     * @return
     */
    public Long createEgunAccountBook( AccountBook accountBook )
        throws RuntimeException;
}
