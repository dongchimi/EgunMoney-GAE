$(document).ready(function(){
	
	// 현재날짜
	var useDate = $("#useDate").val();
	if (StringUtil.isEmpty(useDate)) {
		var currentDate = DateUtil.getCurrentDateYYYYMMDD();

		$("#useDate").val( currentDate );
	}

	// load item
	NewMoneyBookItem.loadMoneyBookItem();
});

function NewMoneyBookItem() {}

NewMoneyBookItem.loadMoneyBookItem = function() {
	var itemOid = EgunLocationUtil.getParamValueByName("itemOid");
	if (!itemOid) return;

	NewMoneyBookItem.getMoneyBookItemByItemOid(itemOid);
};

/**
 * moneyBook Item 상세 등록
 */
NewMoneyBookItem.getMoneyBookItemByItemOid = function(itemOid) {
	var url = "/ws/moneyBookItem/getMonthMoneyBookItem";

	var params = {
		"moneyBookItemId" : itemOid
	}

	egun.httpClient.post(url, params, NewMoneyBookItem.getMoneyBookItemByItemOidCallback);
};

NewMoneyBookItem.getMoneyBookItemByItemOidCallback = function(moneyBookItem) {
	if (!moneyBookItem) return;

	// 수입, 지출, 이체
	var inOutTransfer = moneyBookItem.inOutTransfer;
	$(":input[name=inOutTransfer]").each(function(){
		var $this = $(this);
		if ($this.val() == inOutTransfer) {
			$this.attr("checked", true);
		}
		else {
			$this.removeAttr("checked");
		}
		$this.checkboxradio("refresh");
	});

	// 언제
	var useDate = DateUtil.convertYYYYMMDDToDashedYYYYMMDD(moneyBookItem.useDate);
	$("#useDate").val(useDate);
	// 금액
	var amount = moneyBookItem.amount;
	$("#amount").val(amount);
	// 내용
	var content = moneyBookItem.content;
	$("#content").val(content);
	// 태그
	var tags = moneyBookItem.relatedTags;
	if(tags && tags.length > 0) {
		var tagsString = StringUtil.convertTagListToString(tags);
		$("#tags").val(tagsString);
	}
	
	// 메모
	var description = moneyBookItem.description;
	$("#description").val(description);

	// moneyBookItem
	var moneyBookItemOid = moneyBookItem.oid;
	$("#moneyBookItemOid").val(moneyBookItemOid);
};

/**
 * 새로운 지출/수입건 등록
 */
NewMoneyBookItem.registerMoneyBookItem_Click = function() {
	var currentBookOid = egun.sessionStorage.getItem( EgunSessionStorage.KEY_CURRENT_MONEYBOOK );
	var moneyBookItemOid = $("#moneyBookItemOid").val();

	var moneyDivision = "";
	$("[name=inOutTransfer]").each(function() {
		var $this = $(this);
		var checked = $this.attr("checked");

		if (checked && checked == "checked") {
			moneyDivision = $this.val();
		}
	});

	var useDate = DateUtil.convertDashedYYYYMMDDToYYYYMMDD( $("#useDate").val() );
	var content = StringUtil.trim( $("#content").val() ); 
	var amount = StringUtil.trim( $("#amount").val() );
	var description = StringUtil.trim( $("#description").val() );
	var tags = StringUtil.trim( $("#tags").val() );

	var url = "/ws/moneyBookItem/register";

	var moneyBook = {
		"bookId" : currentBookOid,
		"moneyBookItemOid" : moneyBookItemOid,
		"moneyDivision" : moneyDivision,
		"useDate" : useDate,
		"content" : content, 
		"amount" : amount,
		"description" : description,
		"tags" : tags
	};

	egun.httpClient.post(url, moneyBook, NewMoneyBookItem.registerMoneyBookItem_Callback);
};

NewMoneyBookItem.registerMoneyBookItem_Callback = function(result) {
	location.href="/moneyBook/moneyBookItems.html";
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