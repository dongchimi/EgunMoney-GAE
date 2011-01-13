package com.appspot.egunmoney.service.logic;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jdo.JDOFatalUserException;
import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.springframework.stereotype.Component;

import com.appspot.egunmoney.domain.EgunUser;
import com.appspot.egunmoney.service.EgunUserService;
import com.appspot.egunmoney.utility.PMFProvider;
import com.google.appengine.api.datastore.Key;

@Component
public class EgunUserLogic implements EgunUserService {
	
	/** 로거 */
	private static final Logger logger = Logger.getLogger(EgunUserLogic.class.getSimpleName());
	
	private PersistenceManager pm = null;
	
	@Override
	public Key registerUser(EgunUser user) {
		
		pm = PMFProvider.getPersistenceManager();
//		Transaction currentTransaction = pm.currentTransaction();
		
		try {
//			currentTransaction.begin();
			
			pm.makePersistent(user);
			
//			currentTransaction.commit();

		} catch (JDOFatalUserException e) {
//			currentTransaction.rollback();
			e.printStackTrace();
		} finally {
			if(!pm.isClosed()) {
				pm.close();
			}
		}
		return user.getOid();
	}

	@Override
	public boolean hasEgunUser(EgunUser user) {
		return false;
	}

	@Override
	public EgunUser getUserByEmail(String email) throws RuntimeException {
		EgunUser user = null;
		
		pm = PMFProvider.getPersistenceManager();
		
		try {
			Query getUserQuery = pm.newQuery( EgunUser.class, "userEmail == emailParam" );
			getUserQuery.declareParameters("String emailParam");
			
			List<EgunUser> foundUsers = (List<EgunUser>)getUserQuery.execute(email);
			
			if (!foundUsers.isEmpty()) {
				user = foundUsers.get(0);
			} else {
				logger.log(Level.ALL, "조회한 사용자가 존재하지 않습니다.");
			}
		} catch (JDOObjectNotFoundException e) {
			throw new RuntimeException(email + "에 해당하는 사용자가 존재하지 않습니다.");
		}
		finally {
			pm.close();
		}
		
		return user;
	}
}