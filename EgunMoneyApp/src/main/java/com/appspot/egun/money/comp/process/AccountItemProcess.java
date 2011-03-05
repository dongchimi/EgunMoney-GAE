package com.appspot.egun.money.comp.process;

import java.util.List;

import com.appspot.egun.money.comp.domain.AccountItem;

public interface AccountItemProcess {
	/**
	 * ��� item ���
	 * @param item ��� item
	 * @return item Ű
	 */
	public Long registerAccountBookItem(AccountItem item);

	/**
	 * �ش� ����� id�� �̹��� ��� item ����� ��ȸ
	 * @param bookId ����� id
	 * @return ��θ��
	 */
	public List<AccountItem> findThisMonthAccountItems(long bookId);
}
