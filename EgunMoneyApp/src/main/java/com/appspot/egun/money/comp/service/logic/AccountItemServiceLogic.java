package com.appspot.egun.money.comp.service.logic;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.springframework.stereotype.Component;

import com.appspot.egun.money.comp.domain.AccountItem;
import com.appspot.egun.money.comp.service.AccountItemService;
import com.appspot.egun.money.comp.utility.PMFProvider;
import com.google.appengine.api.datastore.Key;

@Component
public class AccountItemServiceLogic implements AccountItemService {
	
	private PersistenceManager pm = null;
	
	@Override
	public Key registerAccountBookItem(AccountItem item) {
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
	public List<AccountItem> findMyAccountBookItemByEMail(String email) {
		pm = PMFProvider.getPersistenceManager();
		
		Query findQuery = pm.newQuery( AccountItem.class, "" );
		
		
		return null;
	}
}
