package com.appspot.egun.money.service.logic;

import java.util.logging.Logger;

import javax.jdo.JDOFatalUserException;
import javax.jdo.PersistenceManager;

import org.springframework.stereotype.Component;

import com.appspot.egun.money.domain.EgunAccountBook;
import com.appspot.egun.money.service.EgunAccountBookService;
import com.appspot.egun.money.utility.PMFProvider;
import com.google.appengine.api.datastore.Key;

@Component
public class EgunAccountBookLogic implements EgunAccountBookService {

	/** ·Î°Å */
	private static final Logger logger = Logger.getLogger(EgunAccountBookLogic.class.getSimpleName());
	
	private PersistenceManager pm = null;
	
	@Override
	public Key createEgunAccountBook(EgunAccountBook accountBook) {
		
		pm = PMFProvider.getPersistenceManager();
		
//		Transaction currentTransaction = pm.currentTransaction();
//		currentTransaction.begin();
		try {
			
			pm.makePersistentAll(accountBook.getBudgetBook().getBudgetBookItems());
			
			pm.makePersistent(accountBook.getBudgetBook());
			
			pm.makePersistent(accountBook);
			
//			currentTransaction.commit();

		} catch (JDOFatalUserException e) {
//			currentTransaction.rollback();
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(!pm.isClosed()) {
				pm.close();
			}
		}
		return accountBook.getOid();
	}
}
