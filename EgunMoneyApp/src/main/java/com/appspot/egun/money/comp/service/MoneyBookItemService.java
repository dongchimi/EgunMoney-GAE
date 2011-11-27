package com.appspot.egun.money.comp.service;

import java.util.List;

import com.appspot.egun.money.comp.domain.MoneyBookItem;

/**
 * 가계부 Item 서비스
 * 
 * @author dklee
 * @since 2010.09.03
 * 
 */
public interface MoneyBookItemService {
	/**
	 * 장부 item 등록
	 * 
	 * @param item
	 *            장부 item
	 * @return item 키
	 */
	public Long registerAccountBookItem(MoneyBookItem item);

	/**
	 * 장부 item 수정
	 * 
	 * @param item
	 *            장부 item
	 * @return item 키
	 */
	public void modifyAccountBookItem(MoneyBookItem item);

	/**
	 * 기간내의 장부 목록을 조회
	 * 
	 * @param bookId
	 *            장부 id
	 * @param startDay
	 *            시작일자
	 * @param endDay
	 *            종ㄹ일자
	 * @return
	 */
	public List<MoneyBookItem> findMoneyBookItemsByTerm(long bookId, String startDay, String endDay);

	/**
	 * 장부 item 단건 조회
	 * 
	 * @param itemOid
	 *            장부 item
	 * @return
	 */
	public MoneyBookItem getMoneyBookItem(long itemOid);

	/**
	 * 장부 item 삭제
	 * 
	 * @param itemOid
	 *            삭제할 item id
	 */
	public void removeMoneyBookItem(long itemOid);
}
