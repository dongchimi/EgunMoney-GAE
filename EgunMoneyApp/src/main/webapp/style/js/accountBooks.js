$(document).ready(function() {
	getAccountBooks();
});

/**
 * 가계부 목록 조회
 */
function getAccountBooks() {
	var url = "/ws/accountBook/getAccountBooks";
	get(url, null, getAccountBooksCallback);
}

function getAccountBooksCallback(accountBooks) {
	for (var idx = 0; idx < accountBooks.length; idx++) {
		var book = accountBooks[idx];
		$("#accountBooks").append("<li><h3><a href=\"/accountItem/findAccountItems?bookId=" + book.oid + "\" >" + book.accountBookName + "</a></h3><p>기준일 : " + book.baseDay + "</p></li>");
	}
	
	$("#accountBooks").listview("refresh");
}

function onEtc(value) {
	// 기타선택 
	if (value == 9) {
		alert("etc!!");
	}
	else {
		alert("no etc!!");
	}
}

/**
 * item 등록
 */
function registerAccountItem() {
	var url = "/ws/accountItem/register";
	var params = {
			moneyDivision : $("#moneyDivision").val(),
			useDate : $("#useDate").val(),
			because : $("#because").val(),
			amount : $("#amount").val(),
			categoryOid : $("#categoryOid").val(),
			targetOid : $("#targetOid").val(),
			assetOid : $("#assetOid").val(),
			description : $("#description").val(),
			installmentPlan : $("#installmentPlan").val(),
			tags : $("#tags").val()
	};
	post(url, params, registerAccountItemCallback);
}

function registerAccountItemCallback(response) {
	location.href="/accountItem/findAccountItems";
}