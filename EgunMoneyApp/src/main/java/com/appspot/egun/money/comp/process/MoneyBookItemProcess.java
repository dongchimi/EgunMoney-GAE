package com.appspot.egun.money.comp.process;

import java.util.List;

import com.appspot.egun.money.comp.domain.EgunTag;
import com.appspot.egun.money.comp.domain.MoneyBookItem;

public interface MoneyBookItemProcess {
	/**
	 * ��� item ���
	 * 
	 * @param item
	 *            ��� item
	 * @return item Ű
	 */
	public Long registerMoneyBookItem(MoneyBookItem item, List<EgunTag> tags);

	/**
	 * �ش� ����� id�� �̹��� ��� item ����� ��ȸ
	 * 
	 * @param bookId
	 *            ����� id
	 * @return ��θ��
	 */
	public List<MoneyBookItem> findThisMonthMoneyBookItems(long bookId);
}
