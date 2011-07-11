/**
 * @class	HttpClient 서버와 통신자
 * @since	2011.07.10
 * @author dongchimi
 */
function HttpClient() {
	this.callbackFunction = null; // 사용자가 사용하는 콜백 함수
};
HttpClient.prototype = new Object();

HttpClient.prototype.post = function(url, params, callback) {
	$.mobile.pageLoading();
	// TODO 이동규 토큰을 조회함
	
	$.post(url, params, function(response){
		if (HttpClient.isErrorMessage(response.statusCode)) {
			var errorMessage = response.message1;
			return alert(errorMessage);
		}
		
		callback(response.resObj);
		$.mobile.pageLoading(true);
	}, "json");
};

HttpClient.isErrorMessage = function(statusCode) {
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