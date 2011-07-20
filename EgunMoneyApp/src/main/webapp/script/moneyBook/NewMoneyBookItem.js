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
	alert("자산관리");
};
NewMoneyBookItem.manageCategory_Click = function() {
	alert("카테고리관리");
};