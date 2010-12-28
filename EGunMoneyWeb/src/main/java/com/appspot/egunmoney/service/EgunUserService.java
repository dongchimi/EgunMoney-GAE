package com.appspot.egunmoney.service;

import com.appspot.egunmoney.domain.EgunUser;

/**
 * �̰ǸӴ� ����� ����
 * @author dklee
 * @since 2010.09.03
 */
public interface EgunUserService {
	
	public long registerUser(EgunUser user);
	
	public boolean hasEgunUser(EgunUser user);

	public EgunUser getUserByEmail(String email) throws RuntimeException;
}