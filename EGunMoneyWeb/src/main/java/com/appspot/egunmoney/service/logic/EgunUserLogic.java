package com.appspot.egunmoney.service.logic;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import org.springframework.stereotype.Component;

import com.appspot.egunmoney.constant.EgunMoneyConstant;
import com.appspot.egunmoney.domain.EgunUser;
import com.appspot.egunmoney.service.EgunUserService;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@Component
public class EgunUserLogic implements EgunUserService {
	
	private PersistenceManagerFactory pmfInstance = JDOHelper.getPersistenceManagerFactory(EgunMoneyConstant.PERSISTENCE_MANAGER_FACTORY_NAME);
	
	private PersistenceManager pm = null; 
	
	@Override
	public long registerUser(EgunUser user) {
		try {
			pm = pmfInstance.getPersistenceManager();
			
			Key key = KeyFactory.createKey(EgunUser.class.getSimpleName(), user.getUserEmail());
			user.setOid(key);
			pm.makePersistent(user);
		} finally {
			pm.close();
		}
		return user.getOid().getId();
	}

	@Override
	public boolean signInEgunMoney(EgunUser user) {
		return false;
	}

	@Override
	public EgunUser getUserInfo(String email) {
		EgunUser user = null;
		try {
			pm = pmfInstance.getPersistenceManager();
			user = pm.getObjectById(EgunUser.class, email);
		} finally {
			pm.close();
		}
		
		return user;
	}
}