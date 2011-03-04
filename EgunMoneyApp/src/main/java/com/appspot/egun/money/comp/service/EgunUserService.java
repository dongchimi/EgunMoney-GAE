package com.appspot.egun.money.comp.service;

import com.appspot.egun.money.comp.domain.EgunUser;

/**
 * �̰ǸӴ� ����� ����
 * @author dklee
 * @since 2010.09.03
 */
public interface EgunUserService {
	
	public Long registerUser(EgunUser user);
	
	public boolean hasEgunUser(EgunUser user);

	public EgunUser getUserByEmail(String email) throws RuntimeException;
	
	public EgunUser getUserByNickName(String nickName) throws RuntimeException;
}