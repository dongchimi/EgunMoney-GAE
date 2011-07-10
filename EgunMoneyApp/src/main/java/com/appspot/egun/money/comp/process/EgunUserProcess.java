package com.appspot.egun.money.comp.process;

import com.appspot.egun.money.comp.domain.EgunUser;

public interface EgunUserProcess {
	/**
	 * 사용자 등록
	 * @param user 사용자 정보
	 * @return 사용자 ID
	 */
	public Long registerUser(EgunUser user);

	public boolean existEmail(String email);

	public boolean existNickName(String nickName);

	public boolean hasEgunUser(EgunUser user);
	
	/**
	 * 사용자 이메일 또는 닉네임으로 조회
	 * @param email
	 * @return
	 * @throws RuntimeException
	 */
	public EgunUser getUserByEmailOrNickName(String email);
}