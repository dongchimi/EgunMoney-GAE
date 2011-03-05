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

function getAccountBooksCallback(response) {
	var accountBooks = response.resObj;
	for (var idx = 0; idx < accountBooks.length; idx++) {
		var book = accountBooks[idx];
		$("#accountBooks").append("<li><h3><a href=\"/accountItem/findAccountItems?bookId=" + book.oid + "\" >" + book.accountBookName + "</a></h3><p>기준일 : " + book.baseDay + "</p></li>");
	}
	
	$("#accountBooks").listview("refresh");
}