package com.appspot.egun.money.comp.process.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appspot.egun.money.comp.domain.EgunUser;
import com.appspot.egun.money.comp.process.EgunUserProcess;
import com.appspot.egun.money.comp.service.EgunUserService;
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
	public EgunUser getUserByEmailOrNickName(String nickNameOrEmail) throws RuntimeException {
		EgunUser user = egunUserService.getUserByEmail(nickNameOrEmail);
		if (user == null) {
			user = egunUserService.getUserByNickName(nickNameOrEmail);
		}
		return user;
	}
}
