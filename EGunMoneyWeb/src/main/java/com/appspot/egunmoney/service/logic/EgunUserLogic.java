package com.appspot.egunmoney.service.logic;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import org.springframework.stereotype.Component;

import com.appspot.egunmoney.constant.EgunMoneyConstant;
import com.appspot.egunmoney.service.EgunUserService;
import com.google.appengine.api.users.User;

@Component
public class EgunUserLogic implements EgunUserService {
	
	PersistenceManagerFactory pmfInstance = JDOHelper.getPersistenceManagerFactory(EgunMoneyConstant.PERSISTENCE_MANAGER_FACTORY_NAME);

	@Override
	public long registerUser(User user) {
		return 0;
	}

	@Override
	public boolean signInEgunMoney(User user) {
		return false;
	}
}