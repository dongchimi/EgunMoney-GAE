package com.appspot.egun.money.comp.service;

import com.appspot.egun.money.comp.domain.EgunUser;

/**
 * 이건머니 사용자 서비스
 * @author dklee
 * @since 2010.09.03
 */
public interface EgunUserService {
	
	public Long registerUser(EgunUser user);
	
	public boolean hasEgunUser(EgunUser user);

	public EgunUser getUserByEmail(String email) throws RuntimeException;
	
	public EgunUser getUserByNickName(String nickName) throws RuntimeException;
}