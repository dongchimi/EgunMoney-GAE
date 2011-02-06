package com.appspot.egun.money.service;

import java.util.List;

import com.appspot.egun.money.domain.AccountBook;
import com.appspot.egun.money.domain.AccountBookAuthorize;
import com.appspot.egun.money.domain.EgunUser;
import com.google.appengine.api.datastore.Key;

/**
 * ����� Sheet ����
 * @author dklee
 * @since 2010.09.03
 *
 */
public interface AccountBookService {
	
	/**
	 * ��� ���
	 * @param book
	 * @return
	 */
	public Key reigsterAccountBook(AccountBook book);
	
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
	public Key registerAccountBookAuthorize(AccountBookAuthorize authorize);
	
	/**
	 * ����� ���� Ȯ��
	 * @param user
	 * @param book
	 * @return
	 */
	public boolean hasAccountBookAuthorize(EgunUser user, AccountBook book);
}
