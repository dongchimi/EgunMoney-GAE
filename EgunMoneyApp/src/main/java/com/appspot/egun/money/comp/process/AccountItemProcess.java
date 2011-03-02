package com.appspot.egun.money.comp.process;

import java.util.List;

import com.appspot.egun.money.comp.domain.AccountItem;
import com.google.appengine.api.datastore.Key;

public interface AccountItemProcess {
	/**
	 * ��� item ���
	 * @param item ��� item
	 * @return item Ű
	 */
	public Key registerAccountBookItem(AccountItem item);
	
	public List<AccountItem> findMyAccountItemByEMail(String email);
}
