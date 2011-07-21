function NewMoneyBookItem() {}

/**
 * 새로운 지출/수입건 등록
 */
NewMoneyBookItem.registerMoneyBookItem_Click = function() {
	alert('새로운 등록');
};

NewMoneyBookItem.viewMoneyBookItems_Click = function() {
	location.href="./moneyBookItems.html";
};

NewMoneyBookItem.manageAsset_Click = function() {
	location.href="/asset/assets.html";
};
NewMoneyBookItem.manageCategory_Click = function() {
	location.href="/category/categories.html";
};