package com.appspot.egun.money.comp.service.logic;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.springframework.stereotype.Component;

import com.appspot.egun.money.comp.domain.AccountBook;
import com.appspot.egun.money.comp.domain.AccountBookAuthorize;
import com.appspot.egun.money.comp.domain.EgunAuthorize;
import com.appspot.egun.money.comp.domain.EgunUser;
import com.appspot.egun.money.comp.service.AccountBookService;
import com.appspot.egun.money.comp.utility.PMFProvider;

@Component
public class AccountBookServiceLogic implements AccountBookService {

	private PersistenceManager pm = null;

	@Override
	public Long reigsterAccountBook(AccountBook book) {
		try {
			pm = PMFProvider.get().getPersistenceManager();
			pm.makePersistent(book);
		} finally {
			if(!pm.isClosed()) {
				pm.close();
			}
		}
		return book.getOid();
	}

	@Override
	public AccountBook findDefaultAccountBookByUserEmail(String userEmail) {
		return null;
	}

	@Override
	public Long registerAccountBookAuthorize(AccountBookAuthorize authorize) {
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

	@Override
	@SuppressWarnings("unchecked")
	public List<AccountBookAuthorize> findAccountBookAuthorizeByUserEmail(String userEmail, List<EgunAuthorize> authorizes) {
		
		List<AccountBookAuthorize> filteredAuthorizes = new ArrayList<AccountBookAuthorize>();

		pm = PMFProvider.getPersistenceManager();
		
		try {
			Query getUserQuery = pm.newQuery( AccountBookAuthorize.class, "userEmail == emailParam" );
			getUserQuery.declareParameters("String emailParam");
			
			List<AccountBookAuthorize> foundAuthorizes = (List<AccountBookAuthorize>) getUserQuery.execute(userEmail);
			for (AccountBookAuthorize authorize : foundAuthorizes) {
				boolean itsMine = hasAuthorize (authorize.getAuthorize(), authorizes);
				if (itsMine) {
					filteredAuthorizes.add(authorize);
				}
			}
		} catch (JDOObjectNotFoundException e) {
			throw e;
		}
		finally {
			pm.close();
		}
		
		return filteredAuthorizes;
	}
	
	private boolean hasAuthorize(EgunAuthorize source, List<EgunAuthorize> authorizes) {
		for (EgunAuthorize target : authorizes) {
			if (source == target) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public AccountBook getAccountBook(long bookId) {
		AccountBook foundBook = null;
		
		pm = PMFProvider.getPersistenceManager();
		try {
			foundBook = pm.getObjectById( AccountBook.class, bookId );
		} catch (JDOObjectNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			pm.close();
		}
		
		return foundBook;
	}
}
