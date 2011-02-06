package com.appspot.egun.money.process.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.appspot.egun.money.domain.AccountBook;
import com.appspot.egun.money.domain.AccountBookAuthorize;
import com.appspot.egun.money.domain.EgunUser;
import com.appspot.egun.money.process.AccountBookProcess;
import com.appspot.egun.money.service.AccountBookService;
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
