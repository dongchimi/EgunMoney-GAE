package com.appspot.egun.money.comp.process.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appspot.egun.money.comp.domain.EgunUser;
import com.appspot.egun.money.comp.domain.MoneyBook;
import com.appspot.egun.money.comp.domain.MoneyBookAuthorize;
import com.appspot.egun.money.comp.process.EgunUserProcess;
import com.appspot.egun.money.comp.service.AssetService;
import com.appspot.egun.money.comp.service.EgunUserService;
import com.appspot.egun.money.comp.service.MoneyBookService;

@Component
public class EgunUserProcessLogic implements EgunUserProcess {
	@Autowired
	private EgunUserService egunUserService;

	@Autowired
	private MoneyBookService moneyBookService;
	
	@Autowired
	private AssetService assetService;

	@Override
	public Long registerUser(EgunUser user) {
		// 사용자 등록
		Long userOid = egunUserService.registerUser(user);
		user.setOid(userOid);

		// 기본 가계부 등록
		MoneyBook defaultBook = new MoneyBook(user);
		defaultBook.setDefaultBook(true);
		Long bookOid = moneyBookService.reigsterMoneyBook(defaultBook);
		defaultBook.setOid(bookOid);

		// 가계부 권한 등록
		MoneyBookAuthorize bookAuthorize = new MoneyBookAuthorize(user.getUserEmail(), bookOid);
		moneyBookService.registerMoneyBookAuthorize(bookAuthorize);
		
		// 기본 자산 등록
		assetService.createUserAsset(user.getUserEmail());

		return userOid;
	}

	@Override
	public boolean hasEgunUser(EgunUser user) {
		return egunUserService.hasEgunUser(user);
	}

	@Override
	public EgunUser getUserByEmailOrNickName(String nickNameOrEmail){
		EgunUser user = egunUserService.getUserByEmail(nickNameOrEmail);
		if (user == null) {
			user = egunUserService.getUserByNickName(nickNameOrEmail);
		}
		return user;
	}

	@Override
	public EgunUser getUserByAuthToken(String authToken) {
		EgunUser user = egunUserService.getUserByAuthToken(authToken);
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
