package com.appspot.egun.money.comp.service.logic;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.springframework.stereotype.Component;

import com.appspot.egun.money.comp.domain.Authorize;
import com.appspot.egun.money.comp.domain.EgunUser;
import com.appspot.egun.money.comp.domain.MoneyBook;
import com.appspot.egun.money.comp.domain.MoneyBookAuthorize;
import com.appspot.egun.money.comp.service.MoneyBookService;
import com.appspot.egun.money.comp.utility.PMFProvider;

@Component
public class MoneyBookServiceLogic implements MoneyBookService {
	private PersistenceManager pm = null;

	@Override
	public Long reigsterMoneyBook(MoneyBook book) {
		try {
			pm = PMFProvider.get().getPersistenceManager();
			pm.makePersistent(book);
		} finally {
			if (!pm.isClosed()) {
				pm.close();
			}
		}
		return book.getOid();
	}

	@Override
	public MoneyBook findDefaultMoneyBookByUserEmail(String userEmail) {
		return null;
	}

	@Override
	public Long registerMoneyBookAuthorize(MoneyBookAuthorize authorize) {
		try {
			pm = PMFProvider.get().getPersistenceManager();
			pm.makePersistent(authorize);
		} finally {
			if (!pm.isClosed()) {
				pm.close();
			}
		}
		return authorize.getOid();
	}

	@Override
	public boolean hasMoneyBookAuthorize(EgunUser user, MoneyBook book) {

		return false;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<MoneyBookAuthorize> findMoneyBookAuthorizeByUserEmail(String userEmail, List<Authorize> authorizes) {
		List<MoneyBookAuthorize> filteredAuthorizes = new ArrayList<MoneyBookAuthorize>();

		pm = PMFProvider.getPersistenceManager();

		try {
			Query getUserQuery = pm.newQuery(MoneyBookAuthorize.class, "userEmail == emailParam");
			getUserQuery.declareParameters("String emailParam");

			List<MoneyBookAuthorize> foundAuthorizes = (List<MoneyBookAuthorize>) getUserQuery.execute(userEmail);
			for (MoneyBookAuthorize authorize : foundAuthorizes) {
				boolean itsMine = hasAuthorize(authorize.getAuthorize(), authorizes);
				if (itsMine) {
					filteredAuthorizes.add(authorize);
				}
			}
		} catch (JDOObjectNotFoundException e) {
			throw e;
		} finally {
			pm.close();
		}

		return filteredAuthorizes;
	}

	private boolean hasAuthorize(Authorize source, List<Authorize> authorizes) {
		for (Authorize target : authorizes) {
			if (source == target) {
				return true;
			}
		}

		return false;
	}

	@Override
	public MoneyBook getMoneyBook(long bookId) {
		MoneyBook foundBook = null;

		pm = PMFProvider.getPersistenceManager();
		try {
			foundBook = pm.getObjectById(MoneyBook.class, bookId);
		} catch (JDOObjectNotFoundException e) {
			e.printStackTrace();
		} finally {
			pm.close();
		}

		return foundBook;
	}
}
