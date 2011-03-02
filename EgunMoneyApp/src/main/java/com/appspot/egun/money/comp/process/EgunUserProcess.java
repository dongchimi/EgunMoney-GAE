package com.appspot.egun.money.comp.process;

import com.appspot.egun.money.comp.domain.EgunUser;
import com.google.appengine.api.datastore.Key;

public interface EgunUserProcess {
	
	public Key registerUser(EgunUser user);
	
	public boolean hasEgunUser(EgunUser user);

	public EgunUser getUserByEmail(String email) throws RuntimeException;
}