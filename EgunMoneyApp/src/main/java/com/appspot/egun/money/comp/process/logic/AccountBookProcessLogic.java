package com.appspot.egun.money.comp.process.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.appspot.egun.money.comp.domain.AccountBook;
import com.appspot.egun.money.comp.domain.AccountBookAuthorize;
import com.appspot.egun.money.comp.domain.EgunUser;
import com.appspot.egun.money.comp.process.AccountBookProcess;
import com.appspot.egun.money.comp.service.AccountBookService;
import com.google.appengine.api.datastore.Key;

public class AccountBookProcessLogic implements AccountBookProcess {

	@Autowired
	private AccountBookService bookService;
	
	@Override
	public Key reigsterAccountBook(AccountBook book) {
		return null;
	}

	@Override
	public List<AccountBook> findAccountBookByUserEmail(String userEmail) {
		return null;
	}

	@Override
	public AccountBook findDefaultAccountBookByUserEmail(String userEmail) {
		return null;
	}

	@Override
	public Key registerAccountBookAuthorize(AccountBookAuthorize authorize) {
		
		
		return null;
	}

	@Override
	public boolean hasAccountBookAuthorize(EgunUser user, AccountBook book) {
		return false;
	}

}
