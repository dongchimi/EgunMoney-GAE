package com.appspot.egun.money.service;

import java.util.List;

import com.appspot.egun.money.domain.AccountBookItem;
import com.google.appengine.api.datastore.Key;

/**
 * ����� Item ����
 * @author dklee
 * @since 2010.09.03
 *
 */
public interface AccountBookItemService {
	/**
	 * ��� item ���
	 * @param item ��� item
	 * @return item Ű
	 */
	public Key registerAccountBookItem(AccountBookItem item);
	
	public List<AccountBookItem> findMyAccountBookItemByEMail(String email);
}
