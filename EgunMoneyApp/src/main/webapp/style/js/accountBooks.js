$(document).ready(function() {
	getAccountBooks();
});

/**
 * 가계부 목록 조회
 */
function getAccountBooks() {
	$.mobile.pageLoading();
	
	var url = "/ws/accountBook/getAccountBooks";
	$.get(url, null, getAccountBooksCallback);
}

function getAccountBooksCallback(response) {
	$.mobile.pageLoading( true );
	
	var jsonResponse = response[0];
	var statusCode = jsonResponse.statusCode;
	if (statusCode == "99") {
		var errorMessage = jsonResponse.message1;
		alert(errorMessage);
		return;
	}
	
	var accountBooks = response.resObj;

	for (var idx = 0; idx < accountBooks.length; idx++) {
		var book = accountBooks[idx];
		$("#accountBooks").append("<li>" + book.accountBookName +
								  "</li>");
	}
}