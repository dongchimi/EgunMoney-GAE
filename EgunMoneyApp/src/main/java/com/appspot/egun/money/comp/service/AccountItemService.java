package com.appspot.egun.money.comp.service;

import java.util.List;

import com.appspot.egun.money.comp.domain.AccountItem;
import com.google.appengine.api.datastore.Key;

/**
 * ����� Item ����
 * @author dklee
 * @since 2010.09.03
 *
 */
public interface AccountItemService {
	/**
	 * ��� item ���
	 * @param item ��� item
	 * @return item Ű
	 */
	public Key registerAccountBookItem(AccountItem item);
	
	public List<AccountItem> findMyAccountBookItemByEMail(String email);
}
