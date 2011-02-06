package com.appspot.egun.money.process.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appspot.egun.money.domain.EgunUser;
import com.appspot.egun.money.process.EgunUserProcess;
import com.appspot.egun.money.service.EgunUserService;
import com.google.appengine.api.datastore.Key;

@Component
public class EgunUserProcessLogic implements EgunUserProcess {
	
	@Autowired
	private EgunUserService egunUserService;
	
	@Override
	public Key registerUser(EgunUser user) {
		return egunUserService.registerUser(user);
	}

	@Override
	public boolean hasEgunUser(EgunUser user) {
		return egunUserService.hasEgunUser(user);
	}

	@Override
	public EgunUser getUserByEmail(String email) throws RuntimeException {
		return egunUserService.getUserByEmail(email);
	}
}
