$(document).ready(function() {
});

function Categories() {}

/**
 * 카테고리 목록 조회
 */
Categories.getCategories = function() {
	var url = "/ws/category/getCategories";
	egun.httpClient.post(url, null, Categories.getCategoriesCallback);
};

/**
 * 카테고리 목록 조회 콜백
 */
Categories.getCategoriesCallback = function( foundCategories ) {
	
};

///**
// * 가계부 목록 조회
// */
//MoneyBooks.getMoneyBooks=function() {
//	var url = "/ws/moneyBook/getMoneyBooks";
//	egun.httpClient.post(url, null, MoneyBooks.getAccountBooksCallback);
//};
//
///**
// * 가계부 목록 조회 콜
// * @param moneyBooks
// */
//MoneyBooks.getAccountBooksCallback = function( foundMoneyBooks ) {
//	var $targetArea = $("#moneyBooks");
//	for (var idx = 0; idx < foundMoneyBooks.length; idx++) {
//		var book = foundMoneyBooks[idx];
//		$targetArea.append("<li><h3><a href='javascript:;' onclick='MoneyBooks.gotoMoneyBookItems_Click(" + book.oid + ")' >" + book.moneyBookName + "</a></h3><p>기준일 : " + book.baseDay + "</p></li>");
//	}
//	
//	$targetArea.listview("refresh");
//};
//
///**
// * 가계부 목록 선택
// */
//MoneyBooks.gotoMoneyBookItems_Click = function(moneyBookId) {
//	egun.sessionStorage.setItem(EgunSessionStorage.Key_CURRENT_MONEYBOOK, moneyBookId);
//	location.href="./moneyBookItems.html";
//};
