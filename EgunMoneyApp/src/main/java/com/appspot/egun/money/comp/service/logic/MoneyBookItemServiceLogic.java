package com.appspot.egun.money.comp.service.logic;

import java.util.List;
import java.util.logging.Logger;

import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.springframework.stereotype.Component;

import com.appspot.egun.money.app.auth.IndexResource;
import com.appspot.egun.money.comp.domain.MoneyBookItem;
import com.appspot.egun.money.comp.service.MoneyBookItemService;
import com.appspot.egun.money.comp.utility.PMFProvider;

@Component
public class MoneyBookItemServiceLogic implements MoneyBookItemService {
	private PersistenceManager pm = null;

    /** ·Î°Å */
    private static final Logger logger = Logger.getLogger( IndexResource.class.getSimpleName() );

	@Override
	public Long registerAccountBookItem(MoneyBookItem item) {
		try {
			pm = PMFProvider.get().getPersistenceManager();
			pm.makePersistent(item);
		} finally {
			if (!pm.isClosed()) {
				pm.close();
			}
		}
		return item.getOid();
	}
	
	@Override
	public void modifyAccountBookItem(MoneyBookItem item) {
		pm = PMFProvider.getPersistenceManager();
		try {
			MoneyBookItem foundBookItem = pm.getObjectById(MoneyBookItem.class, item.getOid());
			if (foundBookItem != null) {
				foundBookItem.setAccountBookId( item.getAccountBookId() );
				foundBookItem.setAmount(item.getAmount());
				foundBookItem.setContent( item.getContent() );
				foundBookItem.setDescription( item.getDescription() );
				foundBookItem.setInOutTransfer( item.getInOutTransfer() );
				foundBookItem.setTagOids( item.getTagOids() );
				foundBookItem.setUseDate( item.getUseDate() );
			}
		} catch (JDOObjectNotFoundException e) {
			e.printStackTrace();
		} finally {
			pm.close();
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<MoneyBookItem> findMoneyBookItemsByTerm(long bookId, String startDay, String endDay) {
		List<MoneyBookItem> items = null;
		pm = PMFProvider.getPersistenceManager();

		try {
			String filter = "accountBookId == " + bookId + " && useDate >= '" + startDay + "' && useDate < '" + endDay + "'";
			Query getMoneyBookItemQuery = pm.newQuery(MoneyBookItem.class, filter);
			getMoneyBookItemQuery.setOrdering("useDate desc");
			
			//logger.log(Level.WARNING, getMoneyBookItemQuery.toString() );
			List<MoneyBookItem> foundItems = (List<MoneyBookItem>) getMoneyBookItemQuery.execute();
			if (foundItems != null) {
				items = (List<MoneyBookItem>) pm.detachCopyAll( foundItems );
			}
		} catch (JDOObjectNotFoundException e) {
			throw e;
		} finally {
			if (!pm.isClosed()) {
				pm.close();
			}
		}

		return items;
	}

	@Override
	public MoneyBookItem getMoneyBookItem(long itemOid) {
		MoneyBookItem foundBookItem = null;

		pm = PMFProvider.getPersistenceManager();
		try {
			foundBookItem = pm.getObjectById(MoneyBookItem.class, itemOid);
		} catch (JDOObjectNotFoundException e) {
			e.printStackTrace();
		} finally {
			pm.close();
		}

		return foundBookItem;
	}

	@Override
	public void removeMoneyBookItem(long itemOid) {
		pm = PMFProvider.getPersistenceManager();
		try {
			MoneyBookItem foundBookItem = pm.getObjectById(MoneyBookItem.class, itemOid);
			if (foundBookItem != null) {
				pm.deletePersistent(foundBookItem);
			}
		} catch (JDOObjectNotFoundException e) {
			e.printStackTrace();
		} finally {
			pm.close();
		}
	}
}
