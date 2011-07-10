/**
 * @class	HttpClient 서버와 통신자
 * @since	2011.07.10
 * @author dongchimi
 */
function HttpClient() {
	this.callbackFunction = null; // 사용자가 사용하는 콜백 함수
};
HttpClient.prototype = new Object();

HttpClient.prototype.get = function(url, params, callback) {
	this.callbackFunction = callback;
	
	// TODO 이동규 토큰을 조회함
	
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
 * @class	StringUtil	문자열 유틸리티
 */
function StringUtil() {}

/**
 * 문자열의 공백 문자 여부 확인
 * @param	{String}	str	대상 문자열
 * @return	{Boolean}	공백문자 여부 확인 결과
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