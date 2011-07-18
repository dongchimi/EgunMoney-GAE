$(document).ready(function() {
	MoneyBooks.getMoneyBooks();
});

function MoneyBooks() {}

/**
 * 가계부 목록 조회
 */
MoneyBooks.getMoneyBooks=function() {
	var url = "/ws/moneyBook/getMoneyBooks";
	egun.httpClient.post(url, null, MoneyBooks.getAccountBooksCallback);
};

/**
 * 가계부 목록 조회 콜
 * @param moneyBooks
 */
MoneyBooks.getAccountBooksCallback = function( foundMoneyBooks ) {
	var $targetArea = $("#moneyBooks");
	for (var idx = 0; idx < foundMoneyBooks.length; idx++) {
		var book = foundMoneyBooks[idx];
		$targetArea.append("<li><h3><a href='javascript:;' onclick='MoneyBooks.gotoMoneyBookItems_Click(" + book.oid + ")' >" + book.moneyBookName + "</a></h3><p>기준일 : " + book.baseDay + "</p></li>");
	}
	
	$targetArea.listview("refresh");
};

/**
 * 가계부 목록 선택
 */
MoneyBooks.gotoMoneyBookItems_Click = function(moneyBookId) {
	egun.sessionStorage.setItem(EgunSessionStorage.Key_CURRENT_MONEYBOOK, moneyBookId);
	location.href="./MoneyBookItems.html";
};


//
//function onEtc(value) {
//	// 기타선택 
//	if (value == 9) {
//		alert("etc!!");
//	}
//	else {
//		alert("no etc!!");
//	}
//}
//
///**
// * item 등록
// */
//function registerAccountItem() {
//	var url = "/ws/accountItem/register";
//	var params = {
//			moneyDivision : $("#moneyDivision").val(),
//			useDate : $("#useDate").val(),
//			because : $("#because").val(),
//			amount : $("#amount").val(),
//			categoryOid : $("#categoryOid").val(),
//			targetOid : $("#targetOid").val(),
//			assetOid : $("#assetOid").val(),
//			description : $("#description").val(),
//			installmentPlan : $("#installmentPlan").val(),
//			tags : $("#tags").val()
//	};
//	post(url, params, registerAccountItemCallback);
//}
//
///**
// * 가계부 등록 후 콜백
// */
//function registerAccountItemCallback() {
//	location.href="/accountItem/findAccountItems";
//}