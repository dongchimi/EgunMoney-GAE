$(document).ready(function() {
	MoneyBookItems.getMoneyBookItems();
});

function MoneyBookItems() {}
MoneyBookItems.viewMoneyBookItems = function() {
	MoneyBookItems.getMoneyBookItems();
};

MoneyBookItems.getMoneyBookItems = function() {
	var currentMoneyBookId = egun.sessionStorage.getItem(EgunSessionStorage.Key_CURRENT_MONEYBOOK);
	
	var url = "/ws/moneyBookItem/findThisMonthMoneyBookItems";
	var params = {
		"moneyBookId" : currentMoneyBookId
	};
	
	egun.httpClient.post(url, null, MoneyBookItems.getMoneyBookItemsCallback);
};

MoneyBookItems.getMoneyBookItemsCallback = function(moneyBookItems) {
	alert(moneyBookItems);
};

/**
 * 새로운 지출/수입건 등록
 */
MoneyBookItems.registerMoneyBookItem_Click = function() {
	
};