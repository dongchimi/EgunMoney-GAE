package com.appspot.egunmoney.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.appspot.egunmoney.domain.AccountBookItem;
import com.appspot.egunmoney.domain.EgunUser;
import com.appspot.egunmoney.service.AccountBookItemService;
import com.appspot.egunmoney.utility.SessionManager;
import com.google.appengine.api.datastore.Key;

/**
 * MyAccountBook 페이지 Controller
 * @author 이동규
 * @since 2010.11.27`
 */

@Component
@Scope("request")
public class MyAccountBookController {
	
	private List<AccountBookItem> accountBookItems;
	private AccountBookItem accountBookItem;
	
	@Autowired
	private AccountBookItemService bookItemService;
	
	/**
	 * 돈쓴거 입력
	 */
	public String registerAccountBookItem() {
		Key oid = bookItemService.registerAccountBookItem(accountBookItem);
		accountBookItem.setOid(oid);
		return "";
	}
	
	/**
	 * 돈쓴거 목록 조회
	 */
	public String viewAccountBookItems() {
		EgunUser user = SessionManager.getUser();
		String myId = user.getUserEmail(); 
		bookItemService.findMyAccountBookItemByEMail(myId);
		return "";
	}

	public AccountBookItem getAccountBookItem() {
		return accountBookItem;
	}

	public void setAccountBookItem(AccountBookItem accountBookItem) {
		this.accountBookItem = accountBookItem;
	}

	public List<AccountBookItem> getAccountBookItems() {
		return accountBookItems;
	}

	public void setAccountBookItems(List<AccountBookItem> accountBookItems) {
		this.accountBookItems = accountBookItems;
	}
}
