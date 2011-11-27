package com.appspot.egun.money.comp.service;

import java.util.List;

import com.appspot.egun.money.comp.domain.MoneyBookItem;

/**
 * ����� Item ����
 * 
 * @author dklee
 * @since 2010.09.03
 * 
 */
public interface MoneyBookItemService {
	/**
	 * ��� item ���
	 * 
	 * @param item
	 *            ��� item
	 * @return item Ű
	 */
	public Long registerAccountBookItem(MoneyBookItem item);

	/**
	 * ��� item ����
	 * 
	 * @param item
	 *            ��� item
	 * @return item Ű
	 */
	public void modifyAccountBookItem(MoneyBookItem item);

	/**
	 * �Ⱓ���� ��� ����� ��ȸ
	 * 
	 * @param bookId
	 *            ��� id
	 * @param startDay
	 *            ��������
	 * @param endDay
	 *            ��������
	 * @return
	 */
	public List<MoneyBookItem> findMoneyBookItemsByTerm(long bookId, String startDay, String endDay);

	/**
	 * ��� item �ܰ� ��ȸ
	 * 
	 * @param itemOid
	 *            ��� item
	 * @return
	 */
	public MoneyBookItem getMoneyBookItem(long itemOid);

	/**
	 * ��� item ����
	 * 
	 * @param itemOid
	 *            ������ item id
	 */
	public void removeMoneyBookItem(long itemOid);
}
