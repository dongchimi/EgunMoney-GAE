package com.appspot.egunmoney.service;

import com.google.appengine.api.users.User;

/**
 * �̰ǸӴ� ����� ����
 * @author dklee
 * @since 2010.09.03
 */
public interface EgunUserService {
	
	public long registerUser(User user);
	
	public boolean signinEgunMoney(User user);
}