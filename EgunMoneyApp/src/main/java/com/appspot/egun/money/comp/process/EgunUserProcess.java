package com.appspot.egun.money.comp.process;

import com.appspot.egun.money.comp.domain.EgunUser;

public interface EgunUserProcess {
	/**
	 * ����� ���
	 * @param user ����� ����
	 * @return ����� ID
	 */
	public Long registerUser(EgunUser user);

	public boolean existEmail(String email);

	public boolean existNickName(String nickName);

	public boolean hasEgunUser(EgunUser user);
	
	/**
	 * ����� �̸��� �Ǵ� �г������� ��ȸ
	 * @param email
	 * @return
	 * @throws RuntimeException
	 */
	public EgunUser getUserByEmailOrNickName(String email);
}