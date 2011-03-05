package com.appspot.egun.money.comp.process.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appspot.egun.money.comp.domain.AccountBook;
import com.appspot.egun.money.comp.domain.AccountItem;
import com.appspot.egun.money.comp.process.AccountItemProcess;
import com.appspot.egun.money.comp.service.AccountBookService;
import com.appspot.egun.money.comp.service.AccountItemService;
import com.appspot.egun.money.comp.utility.DU;

@Component
public class AccountItemProcessLogic implements AccountItemProcess {

	@Autowired
	private AccountBookService bookService;
	
	@Autowired
	private AccountItemService itemService;
	
	@Override
	public Long registerAccountBookItem(AccountItem item) {
		return itemService.registerAccountBookItem(item);
	}

	@Override
	public List<AccountItem> findThisMonthAccountItems(long bookId) {
		
		AccountBook accountBook = bookService.getAccountBook(bookId);
		String baseDate = accountBook.getBaseDay();
		
		// ������ �������� �Ѵ��� ������.
		String startDay = DU.getThisMonthStartDayByBaseDate(baseDate);
		String endDay = DU.getThisMonthEndDayByBaseDate(baseDate);
		
		List<AccountItem> foundAccountItems = itemService.findAccountItemsByTerm(bookId, startDay, endDay);
		return foundAccountItems;
	}
}
