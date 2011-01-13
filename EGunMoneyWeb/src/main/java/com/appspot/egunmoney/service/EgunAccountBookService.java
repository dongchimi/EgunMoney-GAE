package com.appspot.egunmoney.service;

import com.appspot.egunmoney.domain.EgunAccountBook;
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
