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
	 * 해당 가계부 id의 이번달 장부 item 목록을 조회
	 * 
	 * @param bookId
	 *            가계부 id
	 * @return 장부목록
	 */
	public List<MoneyBookItem> findThisMonthMoneyBookItems(long bookId);
}
