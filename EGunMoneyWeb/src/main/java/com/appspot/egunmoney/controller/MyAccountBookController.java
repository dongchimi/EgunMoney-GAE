package com.appspot.egunmoney.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.appspot.egunmoney.domain.AccountBookItem;
import com.appspot.egunmoney.service.AccountBookItemService;
import com.google.appengine.api.datastore.Key;
import com.opensymphony.xwork2.Action;

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
		return Action.SUCCESS;
	}
	
	/**
	 * 돈쓴거 목록 조회
	 */
	public String viewAccountBookItems() {
		accountBookItems = new ArrayList<AccountBookItem>();
		
		AccountBookItem item = new AccountBookItem();
		item.setUseDate("2010-11-10");
		item.setAmount(20000);
		item.setDescription("엉터리 요리사 외 1건");
		
		accountBookItems.add(item);
		return Action.SUCCESS;
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
