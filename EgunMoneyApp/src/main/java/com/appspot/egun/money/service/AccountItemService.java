package com.appspot.egun.money.service;

import java.util.List;

import com.appspot.egun.money.domain.AccountItem;
import com.google.appengine.api.datastore.Key;

/**
 * 가계부 Item 서비스
 * @author dklee
 * @since 2010.09.03
 *
 */
public interface AccountItemService {
	/**
	 * 장부 item 등록
	 * @param item 장부 item
	 * @return item 키
	 */
	public Key registerAccountBookItem(AccountItem item);
	
	public List<AccountItem> findMyAccountBookItemByEMail(String email);
}
