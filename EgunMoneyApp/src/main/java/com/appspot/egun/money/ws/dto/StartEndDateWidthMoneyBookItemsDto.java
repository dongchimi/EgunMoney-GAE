package com.appspot.egun.money.ws.dto;

import java.util.List;

import com.appspot.egun.money.comp.domain.MoneyBookItem;

public class StartEndDateWidthMoneyBookItemsDto {
	private StartEndDateDto startEndDate = null;
	private List<MoneyBookItem> items = null;
	
	public StartEndDateWidthMoneyBookItemsDto(StartEndDateDto startEndDateDto, List<MoneyBookItem> items) {
		this.startEndDate = startEndDateDto;
		this.items = items;
	}

	public StartEndDateDto getStartEndDate() {
		return startEndDate;
	}

	public void setStartEndDate(StartEndDateDto startEndDate) {
		this.startEndDate = startEndDate;
	}

	public List<MoneyBookItem> getItems() {
		return items;
	}

	public void setItems(List<MoneyBookItem> items) {
		this.items = items;
	}
}
