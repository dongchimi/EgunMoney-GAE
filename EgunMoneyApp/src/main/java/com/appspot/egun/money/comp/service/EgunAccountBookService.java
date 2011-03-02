package com.appspot.egun.money.comp.service;

import com.appspot.egun.money.comp.domain.AccountBook;
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
