package com.appspot.egunmoney.service.logic;

import java.util.List;

import javax.jdo.PersistenceManager;

import org.springframework.stereotype.Component;

import com.appspot.egunmoney.domain.AccountBookItem;
import com.appspot.egunmoney.service.AccountBookItemService;
import com.appspot.egunmoney.utility.PMFInstanceProvider;
import com.google.appengine.api.datastore.Key;

@Component
public class AccountBookItemLogic implements AccountBookItemService {
	
	private PersistenceManager pm = null;
	
	@Override
	public Key registerAccountBookItem(AccountBookItem item) {
		try {
			pm = PMFInstanceProvider.get().getPersistenceManager();
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
