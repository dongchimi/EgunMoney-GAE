package com.appspot.egun.money.service.logic;

import java.util.List;

import javax.jdo.PersistenceManager;

import org.springframework.stereotype.Component;

import com.appspot.egun.money.domain.AccountBookItem;
import com.appspot.egun.money.service.AccountBookItemService;
import com.appspot.egun.money.utility.PMFProvider;
import com.google.appengine.api.datastore.Key;

@Component
public class AccountBookItemLogic implements AccountBookItemService {
	
	private PersistenceManager pm = null;
	
	@Override
	public Key registerAccountBookItem(AccountBookItem item) {
		try {
			pm = PMFProvider.get().getPersistenceManager();
			pm.makePersistent(item);
		} finally {
			if(!pm.isClosed()) {
				pm.close();
			}
		}
		return item.getOid();
	}

	@Override
	public List<AccountBookItem> findMyAccountBookItemByEMail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
}