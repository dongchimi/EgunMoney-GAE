package com.appspot.egun.money.service;

import com.appspot.egun.money.domain.AccountBook;
import com.google.appengine.api.datastore.Key;

/**
 * �̰ǸӴ� ����� ����
 * @author dklee
 * @since 2010.09.03
 */
public interface EgunAccountBookService {
	
	/**
	 * ����� ����
	 * @param accountBook �����
	 * @return
	 */
	public Key createEgunAccountBook(AccountBook accountBook) throws RuntimeException;
}
