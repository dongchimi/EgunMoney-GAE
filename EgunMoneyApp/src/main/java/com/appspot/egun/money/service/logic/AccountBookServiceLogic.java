package com.appspot.egun.money.service.logic;

import java.util.List;

import javax.jdo.PersistenceManager;

import org.springframework.stereotype.Component;

import com.appspot.egun.money.domain.AccountBook;
import com.appspot.egun.money.domain.AccountBookAuthorize;
import com.appspot.egun.money.domain.EgunUser;
import com.appspot.egun.money.service.AccountBookService;
import com.appspot.egun.money.utility.PMFProvider;
import com.google.appengine.api.datastore.Key;

@Component
public class AccountBookServiceLogic implements AccountBookService {

	private PersistenceManager pm = null;

	@Override
	public Key reigsterAccountBook(AccountBook book) {
		return null;
	}

	@Override
	public List<AccountBook> findAccountBookByUserEmail(String userEmail) {
		return null;
	}

	@Override
	public AccountBook findDefaultAccountBookByUserEmail(String userEmail) {
		return null;
	}

	@Override
	public Key registerAccountBookAuthorize(AccountBookAuthorize authorize) {
		try {
			pm = PMFProvider.get().getPersistenceManager();
			pm.makePersistent(authorize);
		} finally {
			if(!pm.isClosed()) {
				pm.close();
			}
		}
		return authorize.getOid();
	}

	@Override
	public boolean hasAccountBookAuthorize(EgunUser user, AccountBook book) {
		
		return false;
	}

}
