package com.appspot.egun.money.process;

import java.util.List;

import com.appspot.egun.money.domain.AccountItem;
import com.google.appengine.api.datastore.Key;

public interface AccountItemProcess {
	/**
	 * 장부 item 등록
	 * @param item 장부 item
	 * @return item 키
	 */
	public Key registerAccountBookItem(AccountItem item);
	
	public List<AccountItem> findMyAccountItemByEMail(String email);
}
