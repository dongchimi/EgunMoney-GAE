package com.appspot.egun.money.process;

import com.appspot.egun.money.domain.EgunUser;
import com.google.appengine.api.datastore.Key;

public interface EgunUserProcess {
	
	public Key registerUser(EgunUser user);
	
	public boolean hasEgunUser(EgunUser user);

	public EgunUser getUserByEmail(String email) throws RuntimeException;
}