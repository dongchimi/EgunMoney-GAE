$(document).ready(function() {
	MoneyBookItems.getMoneyBookItems();
});

function MoneyBookItems() {}

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