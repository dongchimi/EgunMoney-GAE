package com.appspot.egun.money.comp.process.logic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appspot.egun.money.comp.domain.AccountBook;
import com.appspot.egun.money.comp.domain.AccountBookAuthorize;
import com.appspot.egun.money.comp.domain.EgunAuthorize;
import com.appspot.egun.money.comp.domain.EgunUser;
import com.appspot.egun.money.comp.process.AccountBookProcess;
import com.appspot.egun.money.comp.service.AccountBookService;

@Component
public class AccountBookProcessLogic implements AccountBookProcess {

	@Autowired
	private AccountBookService bookService;
	
	@Override
	public Long reigsterAccountBook(AccountBook book) {
		return null;
	}

	@Override
	public List<AccountBook> findAccountBookByUserEmail(String userEmail) {
		// 권한 - 전체, 보기
		List<EgunAuthorize> authorizes = new ArrayList<EgunAuthorize>();
		authorizes.add( EgunAuthorize.READ );
		authorizes.add( EgunAuthorize.READ_WRITE );
		List<AccountBookAuthorize> foundBookAuthorizes = bookService.findAccountBookAuthorizeByUserEmail(userEmail, authorizes);
		
		// 해당하는 장부
		List<AccountBook> foundBooks = new ArrayList<AccountBook>();
		for (AccountBookAuthorize bookAuthorize : foundBookAuthorizes) {
			long bookId = bookAuthorize.getAccountBookOid();
			AccountBook book = bookService.getAccountBook(bookId);
			foundBooks.add(book);
		}
		
		return foundBooks;
	}

	@Override
	public AccountBook findDefaultAccountBookByUserEmail(String userEmail) {
		return null;
	}

	@Override
	public Long registerAccountBookAuthorize(AccountBookAuthorize authorize) {
		
		
		return null;
	}

	@Override
	public boolean hasAccountBookAuthorize(EgunUser user, AccountBook book) {
		return false;
	}

}
