package com.appspot.egunmoney.service.logic;

import javax.jdo.JDOHelper;
import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import org.springframework.stereotype.Component;

import com.appspot.egunmoney.constant.EgunMoneyConstant;
import com.appspot.egunmoney.domain.EgunUser;
import com.appspot.egunmoney.service.EgunUserService;

@Component
public class EgunUserLogic implements EgunUserService {
	
	private PersistenceManagerFactory pmfInstance = JDOHelper.getPersistenceManagerFactory(EgunMoneyConstant.PMFN);
	private PersistenceManager pm = null;
	
	@Override
	public long registerUser(EgunUser user) {
		try {
			getPersistenceManager().makePersistent(user);
		} finally {
			if(!pm.isClosed()) {
				pm.close();
			}
		}
		return user.getOid().getId();
	}

	@Override
	public boolean hasEgunUser(EgunUser user) {
		return false;
	}

	@Override
	public EgunUser getUserInfo(String email) {
		EgunUser user = null;
		try {
			user = (EgunUser) getPersistenceManager().getObjectById(email);
		} catch (JDOObjectNotFoundException e) {
			new RuntimeException(email + "에 해당하는 사용자가 존재하지 않습니다.");
		}
		finally {
			if(!pm.isClosed()) {
				pm.close();
			}
		}
		
		return user;
	}
	
	private PersistenceManager getPersistenceManager() {
		if (pm == null) {
			pm = pmfInstance.getPersistenceManager();
		}
		return pm;
	}
}