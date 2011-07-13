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
	$.mobile.pageLoading();
	
	params = this.addAuthTokenInParams(params);
	
	$.get(url, params, function(response){
		if (HttpClient.isErrorMessage(response.statusCode)) {
			var errorMessage = response.message1;
			return alert(errorMessage);
		}
		
		callback(response.resObj);
		$.mobile.pageLoading(true);
	}, "json");
};

HttpClient.prototype.post = function(url, params, callback) {
	$.mobile.pageLoading();
	
	params = this.addAuthTokenInParams(params);
	
	$.post(url, params, function(response){
		if (HttpClient.isErrorMessage(response.statusCode)) {
			var errorMessage = response.message1;
			return alert(errorMessage);
		}
		
		callback(response.resObj);
		$.mobile.pageLoading(true);
	}, "json");
};

HttpClient.prototype.addAuthTokenInParams = function(params) {
	if(!params) {
		params = {};
	}
	params.authToken = SigninUtil.getAuthToken();
	
	return params;
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

/**
 * 로그인 유틸
 */
function SigninUtil() {}

/**
 * 로그인 ID 셋팅
 */
SigninUtil.setSiginId = function(userEmail) {
	egun.sessionStorage.setItem( EgunSessionStorage.KEY_SIGNIN_ID, userEmail );
};

/**
 * 로그인 ID 조회
 */
SigninUtil.getSigninId =  function() {
	return egun.sessionStorage.getItem( EgunSessionStorage.KEY_SIGNIN_ID );
};

/**
 * 로그인 토큰 셋팅
 */
SigninUtil.setAuthToken = function( authToken ) {
	egun.sessionStorage.setItem( EgunSessionStorage.KEY_AUTH_TOKEN, authToken );
};

/**
 * 인증 토큰 조회
 */
SigninUtil.getAuthToken = function() {
	return egun.sessionStorage.getItem( EgunSessionStorage.KEY_AUTH_TOKEN );
};

/**
 * 로그아웃
 */
SigninUtil.signout = function() {
	egun.sessionStorage.removeItem( EgunSessionStorage.KEY_SIGNIN_ID );
	egun.sessionStorage.removeItem( EgunSessionStorage.KEY_AUTH_TOKEN );
	
	location.href="/auth/signin.html";
};

function EgunSessionStorage() {
	this.hasSessionStorage = false;
	if (window.sessionStorage) {
		this.hasSessionStorage = true;
	} else {
		this.hasSessionStorage = false;
	}
	this.sessionStorage = window.sessionStorage;
};
EgunSessionStorage.prototype = new Object;

EgunSessionStorage.KEY_SIGNIN_ID = "signinId";
EgunSessionStorage.KEY_AUTH_TOKEN = "authorizeToken";
EgunSessionStorage.Key_CURRENT_MONEYBOOK = "currentMoneyBook";

/**
 * set 정보
 */
EgunSessionStorage.prototype.setItem = function(key, value) {
	if (this.hasSessionStorage) {
		this.sessionStorage.setItem(key, value);
	} else {
		window.key = value;
	}
};

/**
 * 정보조회
 */
EgunSessionStorage.prototype.getItem = function(key) {
	var value = null;
	if (this.hasSessionStorage) {
		value = this.sessionStorage.getItem(key);
	} else {
		value = window.key;
	}
	return value;
};

/**
 * 정보 삭제
 */
EgunSessionStorage.prototype.removeItem = function(key) {
	if (this.hasSessionStorage) {
		this.sessionStorage.removeItem(key);
	} else {
		value = window.key;
	}
};


(function(){
	if (!window.egun) {
		window.egun = function(){};
	}
	
	window.egun.httpClient = new HttpClient();
	window.egun.sessionStorage = new EgunSessionStorage();
})();