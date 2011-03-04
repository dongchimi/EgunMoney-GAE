package com.appspot.egun.money.comp.process.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appspot.egun.money.comp.domain.AccountBook;
import com.appspot.egun.money.comp.domain.AccountBookAuthorize;
import com.appspot.egun.money.comp.domain.EgunUser;
import com.appspot.egun.money.comp.process.EgunUserProcess;
import com.appspot.egun.money.comp.service.AccountBookService;
import com.appspot.egun.money.comp.service.EgunUserService;

@Component
public class EgunUserProcessLogic implements EgunUserProcess {
	
	@Autowired
	private EgunUserService egunUserService;
	
	@Autowired
	private AccountBookService accountBookService;
	
	@Override
	public Long registerUser(EgunUser user) {
		
		// 사용자 등록
		Long userOid = egunUserService.registerUser(user);
		user.setOid(userOid);
		
		//기본 가계부 등록
		AccountBook defaultBook = new AccountBook(user);
		Long bookOid = accountBookService.reigsterAccountBook(defaultBook);
		defaultBook.setOid(bookOid);
		
		// 가계부 권한 등록
		AccountBookAuthorize bookAuthorize = new AccountBookAuthorize(user.getUserEmail(), bookOid);
		Long authorizeOid = accountBookService.registerAccountBookAuthorize(bookAuthorize);
		
		return userOid;
	}

	@Override
	public boolean hasEgunUser(EgunUser user) {
		return egunUserService.hasEgunUser(user);
	}

	@Override
	public EgunUser getUserByEmailOrNickName(String nickNameOrEmail) throws RuntimeException {
		EgunUser user = egunUserService.getUserByEmail(nickNameOrEmail);
		if (user == null) {
			user = egunUserService.getUserByNickName(nickNameOrEmail);
		}
		return user;
	}

	@Override
	public boolean existEmail(String email) {
		EgunUser user = egunUserService.getUserByEmail(email);
		if (user != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean existNickName(String nickName) {
		EgunUser user = egunUserService.getUserByNickName(nickName);
		if (user != null) {
			return true;
		}
		return false;
	}
}
