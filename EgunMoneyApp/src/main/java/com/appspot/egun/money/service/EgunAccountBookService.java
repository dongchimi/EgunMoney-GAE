package com.appspot.egun.money.service;

import com.appspot.egun.money.domain.AccountBook;
import com.google.appengine.api.datastore.Key;

/**
 * 이건머니 가계부 서비스
 * @author dklee
 * @since 2010.09.03
 */
public interface EgunAccountBookService {
	
	/**
	 * 가계부 생성
	 * @param accountBook 가계부
	 * @return
	 */
	public Key createEgunAccountBook(AccountBook accountBook) throws RuntimeException;
}
