package com.appspot.egun.money.service;

import com.appspot.egun.money.domain.EgunUser;
import com.google.appengine.api.datastore.Key;

/**
 * �̰ǸӴ� ����� ����
 * @author dklee
 * @since 2010.09.03
 */
public interface EgunUserService {
	
	public Key registerUser(EgunUser user);
	
	public boolean hasEgunUser(EgunUser user);

	public EgunUser getUserByEmail(String email) throws RuntimeException;
}