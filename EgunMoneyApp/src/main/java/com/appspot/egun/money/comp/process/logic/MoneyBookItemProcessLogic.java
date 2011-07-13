package com.appspot.egun.money.comp.process.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appspot.egun.money.comp.domain.EgunTag;
import com.appspot.egun.money.comp.domain.MoneyBook;
import com.appspot.egun.money.comp.domain.MoneyBookItem;
import com.appspot.egun.money.comp.process.MoneyBookItemProcess;
import com.appspot.egun.money.comp.service.ContentTagService;
import com.appspot.egun.money.comp.service.MoneyBookItemService;
import com.appspot.egun.money.comp.service.MoneyBookService;
import com.appspot.egun.money.comp.utility.DateU;

@Component
public class MoneyBookItemProcessLogic implements MoneyBookItemProcess {
	@Autowired
	private MoneyBookService bookService;

	@Autowired
	private MoneyBookItemService itemService;

	@Autowired
	private ContentTagService tagService;

	@Override
	public Long registerMoneyBookItem(MoneyBookItem item, List<EgunTag> tags) {
		// List<Long> tagOids = null;
		// if ( tags != null && !tags.isEmpty() )
		// {
		// tagOids = tagService.registerContentTags( tags );
		// //item.setTagOids( tagOids );
		// }
		//
		// Long itemOid = itemService.registerAccountBookItem( item );
		//
		// return itemOid;
		return null;
	}

	@Override
	public List<MoneyBookItem> findThisMonthMoneyBookItems(long bookId) {
		MoneyBook accountBook = bookService.getMoneyBook(bookId);
		String baseDate = accountBook.getBaseDay();

		// 기준일 기준으로 한달을 가져옴.
		String startDay = DateU.getThisMonthStartDayByBaseDate(baseDate);
		String endDay = DateU.getThisMonthEndDayByBaseDate(baseDate);

		List<MoneyBookItem> foundAccountItems = itemService.findMoneyBookItemsByTerm(bookId, startDay, endDay);
		return foundAccountItems;
	}
}
