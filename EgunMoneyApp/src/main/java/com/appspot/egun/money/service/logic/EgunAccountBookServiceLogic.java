package com.appspot.egun.money.service.logic;

import java.util.logging.Logger;

import javax.jdo.PersistenceManager;

import org.springframework.stereotype.Component;

import com.appspot.egun.money.domain.AccountBook;
import com.appspot.egun.money.service.EgunAccountBookService;
import com.appspot.egun.money.utility.PMFProvider;
import com.google.appengine.api.datastore.Key;

@Component
public class EgunAccountBookServiceLogic implements EgunAccountBookService {

	/** ·Î°Å */
	private static final Logger logger = Logger.getLogger(EgunAccountBookServiceLogic.class.getSimpleName());
	
	private PersistenceManager pm = null;
	
	@Override
	public Key createEgunAccountBook(AccountBook accountBook) throws RuntimeException {
		
		pm = PMFProvider.getPersistenceManager();
		
		try {
			pm.makePersistent(accountBook);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if(!pm.isClosed()) {
				pm.close();
			}
		}
		return accountBook.getOid();
	}
}
