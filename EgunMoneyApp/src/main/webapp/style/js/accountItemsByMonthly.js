$(document).ready(function() {
	getAccountItems();
});

function getAccountItems() {
	var url = "/ws/accountItem/findThisMonthAccountItems";
	get(url, null, getAccountItemsCallback);
}

function getAccountItemsCallback(accountItems) {
	
	alert(accountItems);
}