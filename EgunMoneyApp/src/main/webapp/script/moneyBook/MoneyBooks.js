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

	// 내 자산 관리 
	var myAssetLi = MoneyBooks.buildMyAssetLi();
	$targetArea.append( myAssetLi );

	$targetArea.listview("refresh");
};

/**
 * 내 자산 목록 li
 */
MoneyBooks.buildMyAssetLi = function() {
	var li = "<li><h3><a href='javascript:;' onclick='MoneyBooks.gotoAsset_Click()' >내 자산 목록 관리</a></h3></li>";

	return li;
};

MoneyBooks.gotoAsset_Click = function() {
	location.href="/asset/assets.html";
};


/**
 * 가계부 목록 선택
 */
MoneyBooks.gotoMoneyBookItems_Click = function(moneyBookId, baseDay) {
	egun.sessionStorage.setItem(EgunSessionStorage.KEY_CURRENT_MONEYBOOK, moneyBookId);
	location.href="./moneyBookItems.html";
};
