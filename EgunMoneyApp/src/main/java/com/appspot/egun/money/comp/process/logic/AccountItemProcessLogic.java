package com.appspot.egun.money.comp.process.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appspot.egun.money.comp.domain.AccountBook;
import com.appspot.egun.money.comp.domain.AccountItem;
import com.appspot.egun.money.comp.domain.ContentTag;
import com.appspot.egun.money.comp.process.AccountItemProcess;
import com.appspot.egun.money.comp.service.AccountBookService;
import com.appspot.egun.money.comp.service.AccountItemService;
import com.appspot.egun.money.comp.service.ContentTagService;
import com.appspot.egun.money.comp.utility.DU;

@Component
public class AccountItemProcessLogic implements AccountItemProcess {

	@Autowired
	private AccountBookService bookService;
	
	@Autowired
	private AccountItemService itemService;
	
	@Autowired
	private ContentTagService tagService;
	
	@Override
	public Long registerAccountBookItem(AccountItem item, List<ContentTag> tags) {
		List<Long> tagOids = null;
		if (tags != null && !tags.isEmpty()) {
			tagOids = tagService.registerContentTags(tags);
			item.setTagOids(tagOids);
		}
		
		Long itemOid = itemService.registerAccountBookItem(item);
		
		return itemOid;
	}

	@Override
	public List<AccountItem> findThisMonthAccountItems(long bookId) {
		
		AccountBook accountBook = bookService.getAccountBook(bookId);
		String baseDate = accountBook.getBaseDay();
		
		// 기준일 기준으로 한달을 가져옴.
		String startDay = DU.getThisMonthStartDayByBaseDate(baseDate);
		String endDay = DU.getThisMonthEndDayByBaseDate(baseDate);
		
		List<AccountItem> foundAccountItems = itemService.findAccountItemsByTerm(bookId, startDay, endDay);
		return foundAccountItems;
	}
}
