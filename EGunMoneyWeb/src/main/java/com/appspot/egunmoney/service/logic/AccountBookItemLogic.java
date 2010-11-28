package com.appspot.egunmoney.service.logic;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import com.appspot.egunmoney.constant.EgunMoneyConstant;
import com.appspot.egunmoney.domain.AccountBookItem;
import com.appspot.egunmoney.service.AccountBookItemService;
import com.google.appengine.api.datastore.Key;

public class AccountBookItemLogic implements AccountBookItemService {
	
	private PersistenceManagerFactory pmfInstance = JDOHelper.getPersistenceManagerFactory(EgunMoneyConstant.PMFN);
	private PersistenceManager pm = null;
	
	@Override
	public Key registerAccountBookItem(AccountBookItem item) {
		try {
			pm = pmfInstance.getPersistenceManager();
			pm.makePersistent(item);
		} finally {
			if(!pm.isClosed()) {
				pm.close();
			}
		}
		return item.getOid();
	}
}
