package com.appspot.egun.money.comp.process.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appspot.egun.money.comp.domain.EgunUser;
import com.appspot.egun.money.comp.domain.MoneyBook;
import com.appspot.egun.money.comp.domain.MoneyBookAuthorize;
import com.appspot.egun.money.comp.process.MoneyBookProcess;
import com.appspot.egun.money.comp.service.MoneyBookService;

@Component
public class MoneyBookProcessLogic implements MoneyBookProcess {

	@Autowired
	private MoneyBookService bookService;

	@Override
	public Long reigsterMoneyBook(MoneyBook book) {
		return null;
	}

	@Override
	public List<MoneyBook> findMoneyBookByUserEmail(String userEmail) {
		// 권한 - 전체, 보기
//		List<Authorize> authorizes = new ArrayList<Authorize>();
//		authorizes.add(Authorize.READ);
//		authorizes.add(Authorize.READ_WRITE);
//		List<MoneyBookAuthorize> foundAuthorizes = bookService.findAccountBookAuthorizeByUserEmail(userEmail, authorizes);
//
//		// 해당하는 장부
//		List<MoneyBook> foundBooks = new ArrayList<MoneyBook>();
//		for (MoneyBookAuthorize bookAuthorize : foundAuthorizes) {
//			long bookId = bookAuthorize.getMoneyBookOid();
//			MoneyBook book = bookService.getAccountBook(bookId);
//			foundBooks.add(book);
//		}
//
//		return foundBooks;
		return null;
	}

	@Override
	public MoneyBook findDefaultMoneyBookByUserEmail(String userEmail) {
		return null;
	}

	@Override
	public Long registerMoneyBookAuthorize(MoneyBookAuthorize authorize) {
		return null;
	}

	@Override
	public boolean hasMoneyBookAuthorize(EgunUser user, MoneyBook book) {
		return false;
	}

}
