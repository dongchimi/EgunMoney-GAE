package com.appspot.egun.money.comp.process.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appspot.egun.money.comp.domain.AccountItem;
import com.appspot.egun.money.comp.process.AccountItemProcess;
import com.appspot.egun.money.comp.service.AccountBookService;
import com.appspot.egun.money.comp.service.AccountItemService;
import com.google.appengine.api.datastore.Key;

@Component
public class AccountItemProcessLogic implements AccountItemProcess {

	@Autowired
	private AccountItemService itemService;
	
	@Autowired
	private AccountBookService bookService;
	
	@Override
	public Key registerAccountBookItem(AccountItem item) {
		return itemService.registerAccountBookItem(item);
	}

	@Override
	public List<AccountItem> findMyAccountItemByEMail(String userEmail) {
		
		// 가계부 권한 조회
		bookService.findAccountBookByUserEmail(userEmail);
		
		
		return itemService.findMyAccountBookItemByEMail(userEmail);
	}

}
