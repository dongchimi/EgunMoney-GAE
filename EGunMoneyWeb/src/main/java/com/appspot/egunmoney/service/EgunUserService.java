package com.appspot.egunmoney.service;

import com.google.appengine.api.users.User;

/**
 * 이건머니 사용자 서비스
 * @author dklee
 * @since 2010.09.03
 */
public interface EgunUserService {
	
	public long registerUser(User user);
	
	public boolean signinEgunMoney(User user);
}