$(document).ready(function() {
	// 시작일과 종료일 셋팅
	// MoneyBookItems.getTodayBaseDayOfMoneyBook();
	MoneyBookItems.getMoneyBookItems();
});

function MoneyBookItems() {}

MoneyBookItems.getMoneyBookItems = function() {
	var currentMoneyBookId = egun.sessionStorage.getItem(EgunSessionStorage.KEY_CURRENT_MONEYBOOK);
	
	var startDay = $("#startDay").attr("data-yyyyMMdd");
	var endDay = $("#endDay").attr("data-yyyyMMdd");

	var url = "/ws/moneyBookItem/findMoneyBookItemsByTerm";
	var params = {
		"moneyBookId" : currentMoneyBookId,
		"startDay" : startDay,
		"endDay" : endDay
	};
	
	egun.httpClient.post(url, params, MoneyBookItems.getMoneyBookItemsCallback);
};
MoneyBookItems.getMoneyBookItemsCallback = function( foundMoneyBookItemsWithStartEndDay ) {
	console.log(foundMoneyBookItemsWithStartEndDay);

	var $moneyBookItems = $("#moneyBookItems").empty();

	// 시작, 종료일자 셋팅
	var foundStartEndBaseDate = foundMoneyBookItemsWithStartEndDay.startEndDate;
	var startDay = foundStartEndBaseDate.startDay;
	var endDay = foundStartEndBaseDate.endDay;
	$("#startDay").text( DateUtil.convertYYYYmmdDToYYYYMMDDKorean( startDay ) ).attr("data-yyyyMMdd", startDay);
	$("#endDay").text( DateUtil.convertYYYYmmdDToYYYYMMDDKorean( endDay ) ).attr("data-yyyyMMdd", endDay);	

	// items ..
	var foundMoneyBookItems = foundMoneyBookItemsWithStartEndDay.items;

	var drawedDates = [];
	var lis = "";
	var foundMoneyBookItemsLength = foundMoneyBookItems.length;
	for (var idx = 0; idx < foundMoneyBookItemsLength; idx++) {
		var item = foundMoneyBookItems[idx];

		var inOutTransferName = MoneyBookItems.getInOutTransferName( item.inOutTransfer );
		var useDate = DateUtil.convertYYYYMMDDToDashedYYYYMMDD( item.useDate );
		var amount = StringUtil.addComma(item.amount);

		var liHeader = "";
		if (!drawedDates.contains(item.useDate)) {
			var totalAmount = MoneyBookItems.getTotalAmountUntilDay(foundMoneyBookItems, item.useDate);
			liHeader = "<li data-role='list-divider'>" + useDate + "<span class='ui-li-count ui-btn-up-c ui-btn-corner-all'>" + totalAmount + "</span></li>";
			drawedDates.push(item.useDate);
		}

		var li = ""
			+ "<li>"
			+ "		<a href='javascript:;' onclick='MoneyBookItems.viewMoneyBookItems_Click(" + item.oid + ")' >" 
			// + "			<img src='/img/type.gif' alt='지출타입' >"
			+ "			<h3>" + inOutTransferName + " : " + item.content + "</h3>"
			+ "			<p>사용일 : " + useDate + "</p>"
			+ "			<p>금액   : " + amount + "</p>"
			+ "			<p>관련어 : " + StringUtil.convertTagListToString(item.relatedTags) + "</p>"
			+ "		</a>"
			+ "		<a href='javascript:;' onclick='MoneyBookItems.removeMoneyBookItem_Click(" + item.oid + ")' data-transition='slideup'>삭제</a>"
			+ "</li>";
		lis = lis + liHeader + li;
	}
	$moneyBookItems.append( lis );

	$moneyBookItems.listview("refresh");
};

MoneyBookItems.getInOutTransferName = function(inOutTransfer) {
	var inOutTransferName = "";
	if ("IN" == inOutTransfer) {
		inOutTransferName = "수입";
	} 
	else if ("OUT" == inOutTransfer) {
		inOutTransferName = "지출";
	}
	else if ("TRANSFER" == inOutTransfer) {
		inOutTransferName = "이체";
	}

	return inOutTransferName;
};

MoneyBookItems.getTotalAmountUntilDay = function(moneyBookItems, day) {
	if (!moneyBookItems || moneyBookItems.length < 1) return 0;

	var totalAmount = 0;
	var itemLength = moneyBookItems.length;
	for (var idx = 0; idx < itemLength; idx++) {
		var item = moneyBookItems[idx];

		if(item.useDate > day) {
			continue;
		}
		if (item.inOutTransfer == "OUT" || item.inOutTransfer == "TRANSFER") {
			totalAmount -= Number(item.amount);
		}
		else if (item.inOutTransfer == "IN") {
			totalAmount += Number(item.amount);
		}
	}

	return StringUtil.addComma( String(totalAmount) );
};

MoneyBookItems.viewMoneyBookItems = function() {
	MoneyBookItems.getMoneyBookItems();
};

/**
 * 항목 삭제
 */
MoneyBookItems.removeMoneyBookItem_Click = function(itemOid) {
	var ok = confirm("해단 건을 삭제할 까요?");
	if (!ok) return;

	var url = "/ws/moneyBookItem/removeMonthMoneyBookItems";
	var params = {
		"moneyBookItemId" : itemOid
	};
	
	egun.httpClient.post(url, params, MoneyBookItems.removeMoneyBookItemCallbacnk);
};

MoneyBookItems.removeMoneyBookItemCallbacnk = function() {
	MoneyBookItems.getMoneyBookItems();
};

/**
 * 항목 선택
 */
MoneyBookItems.viewMoneyBookItems_Click = function(itemOid) {
	location.href="./newMoneyBookItem.html?itemOid=" + itemOid;
};

/**
 * 이전달 조회
 */
MoneyBookItems.gotoPrev_Click = function() {

	var startDay = $("#startDay").attr("data-yyyyMMdd");
	var endDay = $("#endDay").attr("data-yyyyMMdd");

	$("#startDay").attr("data-yyyyMMdd", DateUtil.minusMonth(startDay, 1) );
	$("#endDay").attr("data-yyyyMMdd", DateUtil.minusMonth(endDay, 1) );

	MoneyBookItems.getMoneyBookItems();
};

MoneyBookItems.getNextMonth_Click = function() {
	// TODO 이동규
	var startDay = $("#startDay").attr("data-yyyyMMdd");
	var endDay = $("#endDay").attr("data-yyyyMMdd");

	$("#startDay").attr("data-yyyyMMdd", DateUtil.addMonth(startDay, 1) );
	$("#endDay").attr("data-yyyyMMdd", DateUtil.addMonth(endDay, 1) );

	MoneyBookItems.getMoneyBookItems();
};