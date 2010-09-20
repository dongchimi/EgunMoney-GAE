package com.appspot.egunmoney.service.logic;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import org.springframework.stereotype.Component;

import com.appspot.egunmoney.constant.EgunMoneyConstant;
import com.appspot.egunmoney.domain.EgunUser;
import com.appspot.egunmoney.service.EgunUserService;

@Component
public class EgunUserLogic implements EgunUserService {
	
	private PersistenceManagerFactory pmfInstance = JDOHelper.getPersistenceManagerFactory(EgunMoneyConstant.PERSISTENCE_MANAGER_FACTORY_NAME);
	
	private PersistenceManager pm = pmfInstance.getPersistenceManager(); 
	
	@Override
	public long registerUser(EgunUser user) {
		try {
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
}