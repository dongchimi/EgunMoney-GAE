/**
 * @class	HttpClient ������ �����
 * @since	2011.07.10
 * @author dongchimi
 */
function HttpClient() {
	this.callbackFunction = null; // ����ڰ� ����ϴ� �ݹ� �Լ�
};
HttpClient.prototype = new Object();

HttpClient.prototype.get = function(url, params, callback) {
	this.callbackFunction = callback;
	
	// TODO �̵��� ��ū�� ��ȸ��
	
	$.get(url, params, this.responseHandler, "json");
};
HttpClient.prototype.post = function(url, params, callback) {
	this.callbackFunction = callback;
	
	$.post(url, params, this.responseHandler, "json");
};
HttpClient.prototype.responseHandler = function(response) {
	if (this.isErrorMessage(response.statusCode)) {
		var errorMessage = response.message1;
		return alert(errorMessage);
	}
	
	this.callbackFunction(response.resObj);
};
HttpClient.prototype.isErrorMessage = function(statusCode) {
	return "99" == statusCode;
};





/**
 * @class	StringUtil	���ڿ� ��ƿ��Ƽ
 */
function StringUtil() {}

/**
 * ���ڿ��� ���� ���� ���� Ȯ��
 * @param	{String}	str	��� ���ڿ�
 * @return	{Boolean}	���鹮�� ���� Ȯ�� ���
 */
StringUtil.isEmpty = function(str) {
	if (str == undefined) return true;
	
	if (str == null) return true;
	if (str.trim().length < 1) return true;
};





(function(){
	if (!window.egun) {
		window.egun = function(){};
	}
	
	window.egun.httpClient = new HttpClient();
})();