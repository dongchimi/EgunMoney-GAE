var callback;

function get(url, params, cb) {
	callback = cb;
	
	$.get(url, params, postGetCallback, "json");
}

function post(url, params, cb) {
	callback = cb;
	
	$.post(url, params, postGetCallback, "json");
}

function postGetCallback(response) {
	
	var jsonResponse = response;
	var statusCode = jsonResponse.statusCode;
	if (statusCode == "99") {
		var errorMessage = jsonResponse.message1;
		return alert(errorMessage);
	}
	
	callback(jsonResponse.resObj);
}

function StringUtil() {}

/**
 * ���ڿ��� ���� ���� ���� Ȯ��
 * @param	{String}	str	��� ���ڿ�
 * @return	{Boolean}	���鹮�� ���� Ȯ�� ���
 */
StringUtil.prototype.isEmpty = function(str) {
	if (str == undefined) return true;
	
	if (str == null) return true;
	if (str.trim().length < 1) return true;
};