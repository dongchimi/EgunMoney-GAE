package com.appspot.egun.money.comp.service.logic;

import java.util.List;

import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.springframework.stereotype.Component;

import com.appspot.egun.money.comp.domain.AccountItem;
import com.appspot.egun.money.comp.service.AccountItemService;
import com.appspot.egun.money.comp.utility.PMFProvider;

@Component
public class AccountItemServiceLogic implements AccountItemService {
	
	private PersistenceManager pm = null;
	
	@Override
	public Long registerAccountBookItem(AccountItem item) {
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

	@SuppressWarnings("unchecked")
	@Override
	public List<AccountItem> findAccountItemsByTerm(long bookId, String startDay, String endDay) {
		List<AccountItem> foundItems = null;

		pm = PMFProvider.getPersistenceManager();
		
		try {
			Query getUserQuery = pm.newQuery( AccountItem.class, "accountBookId == " + bookId + " && useDate <= " + startDay  + " && useDate >= " + endDay );
			foundItems = (List<AccountItem>) getUserQuery.execute();
//			Query getUserQuery = pm.newQuery( AccountItem.class, "accountBookId == bookIdParam");
//			getUserQuery.declareParameters("Long bookIdParam");
			
			foundItems = (List<AccountItem>) getUserQuery.execute(bookId);
		} catch (JDOObjectNotFoundException e) {
			throw e;
		}
		finally {
			if(!pm.isClosed()) {
				pm.close();
			}
		}
		
		return foundItems;
	}
}
