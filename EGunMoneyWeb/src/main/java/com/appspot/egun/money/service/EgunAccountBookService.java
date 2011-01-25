package com.appspot.egun.money.service;

import com.appspot.egun.money.domain.EgunAccountBook;
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
	public Key createEgunAccountBook(EgunAccountBook accountBook);
}
