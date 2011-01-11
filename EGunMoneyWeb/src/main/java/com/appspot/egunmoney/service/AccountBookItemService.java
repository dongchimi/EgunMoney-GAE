package com.appspot.egunmoney.service;

import java.util.List;

import com.appspot.egunmoney.domain.AccountBookItem;
import com.google.appengine.api.datastore.Key;

/**
 * 가계부 Item 서비스
 * @author dklee
 * @since 2010.09.03
 *
 */
public interface AccountBookItemService {
	/**
	 * 장부 item 등록
	 * @param item 장부 item
	 * @return item 키
	 */
	public Key registerAccountBookItem(AccountBookItem item);
	
	public List<AccountBookItem> findMyAccountBookItemByEMail(String email);
}
