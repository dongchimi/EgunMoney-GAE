package com.appspot.egun.money.comp.process;

import java.util.List;

import com.appspot.egun.money.comp.domain.AccountBook;
import com.appspot.egun.money.comp.domain.AccountBookAuthorize;
import com.appspot.egun.money.comp.domain.EgunUser;

public interface AccountBookProcess {
	
	/**
	 * ��� ���
	 * @param book
	 * @return
	 */
	public Long reigsterAccountBook(AccountBook book);
	
	/**
	 * ������� ��� ��� ��ȸ
	 * @param userEmail ����� �̸���
	 * @return ��� ���
	 */
	public List<AccountBook> findAccountBookByUserEmail(String userEmail);
	
	/**
	 * ������� �⺻ ��� ��ȸ
	 * @param userEmail ����� �̸���
	 * @return ��� 
	 */
	public AccountBook findDefaultAccountBookByUserEmail(String userEmail);
	
	/**
	 * ����� ���� �ο�
	 * @param authorize
	 * @return
	 */
	public Long registerAccountBookAuthorize(AccountBookAuthorize authorize);
	
	/**
	 * ����� ���� Ȯ��
	 * @param user
	 * @param book
	 * @return
	 */
	public boolean hasAccountBookAuthorize(EgunUser user, AccountBook book);
}
