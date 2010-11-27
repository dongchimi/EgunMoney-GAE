package com.appspot.egunmoney.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.appspot.egunmoney.domain.AccountBookItem;
import com.opensymphony.xwork2.Action;

/**
 * MyAccountBook ������ Controller
 * @author �̵���
 * @since 2010.11.27`
 */

@Component
@Scope("request")
public class MyAccountBookController {
	
	private List<AccountBookItem> accountBookItems;
	private AccountBookItem accountBookItem;
	
	/**
	 * ������ �Է�
	 */
	public String registerAccountBookItem() {
		return Action.SUCCESS;
	}
	
	/**
	 * ������ ��� ��ȸ
	 */
	public String viewAccountBookItems() {
		accountBookItems = new ArrayList<AccountBookItem>();
		
		AccountBookItem item = new AccountBookItem();
		item.setUseDate("2010-11-10");
		item.setAmount(20000);
		item.setDescription("���͸� �丮�� �� 1��");
		
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
