package com.appspot.egun.money.comp.process;

import java.util.List;

import com.appspot.egun.money.comp.domain.EgunTag;
import com.appspot.egun.money.comp.domain.MoneyBookItem;

public interface MoneyBookItemProcess {
	/**
	 * 장부 item 등록
	 * 
	 * @param item
	 *            장부 item
	 * @return item 키
	 */
	public Long registerMoneyBookItem(MoneyBookItem item, List<EgunTag> tags);
	
	/**
	 * 장부 item 수정
	 * 
	 * @param item 장부 item
	 * @return item 키
	 */
	public void modifyMoneyBookItem(MoneyBookItem item, List<EgunTag> tags);
	
	/**
	 * 해당 가계부 id의 이번달 장부 item 목록을 조회
	 * 
	 * @param bookId
	 *            가계부 id
	 * @param startDay TODO
	 * @param endDay TODO
	 * @return 장부목록
	 */
	public List<MoneyBookItem> findMoneyBookItemsByTerm(long bookId, String startDay, String endDay);
	
	/**
	 * 아이템 삭제
	 * @param	bookItemOid	아이템 id
	 * @return 성공건수
	 */
	public boolean removeMonthMoneyBookItems(long itemOid);

	/**
	 * 아이템 조회
	 * @param	bookItemOid	아이템 id
	 * @return 찾은 아이템
	 */
	public MoneyBookItem getMoneyBookItem(String moneyBookItemId);

}
