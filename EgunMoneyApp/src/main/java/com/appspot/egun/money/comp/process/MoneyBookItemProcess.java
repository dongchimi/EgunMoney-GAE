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
	 * ��� item ����
	 * 
	 * @param item ��� item
	 * @return item Ű
	 */
	public void modifyMoneyBookItem(MoneyBookItem item, List<EgunTag> tags);
	
	/**
	 * �ش� ����� id�� �̹��� ��� item ����� ��ȸ
	 * 
	 * @param bookId
	 *            ����� id
	 * @param startDay TODO
	 * @param endDay TODO
	 * @return ��θ��
	 */
	public List<MoneyBookItem> findMoneyBookItemsByTerm(long bookId, String startDay, String endDay);
	
	/**
	 * ������ ����
	 * @param	bookItemOid	������ id
	 * @return �����Ǽ�
	 */
	public boolean removeMonthMoneyBookItems(long itemOid);

	/**
	 * ������ ��ȸ
	 * @param	bookItemOid	������ id
	 * @return ã�� ������
	 */
	public MoneyBookItem getMoneyBookItem(String moneyBookItemId);

}
