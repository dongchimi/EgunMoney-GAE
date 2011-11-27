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
	$.mobile.showPageLoadingMsg();
	
	params = this.addAuthTokenInParams(params);
	
	$.get(url, params, function(response){
			if (HttpClient.isErrorMessage(response.statusCode)) {
				var errorMessage = response.message1;
				$.mobile.hidePageLoadingMsg();	
				return alert(errorMessage);
			}
			
			callback(response.resObj);
			$.mobile.hidePageLoadingMsg();
		}, "json");
};

HttpClient.prototype.post = function(url, params, callback) {
	$.mobile.showPageLoadingMsg();
	
	params = this.addAuthTokenInParams(params);
	
	$.post(url, params, function(response){
			if (HttpClient.isErrorMessage(response.statusCode)) {
				var errorMessage = response.message1;
				return alert(errorMessage);
			}
			
			callback(response.resObj);
			$.mobile.hidePageLoadingMsg();
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

StringUtil.trim = function(str) {
	if (!str || str.length < 1) return "";

	return String(str).replace(/(^s*)|(s*$)/g, "");
};

StringUtil.addComma = function(sourceString) {
	if (StringUtil.trim(sourceString).length < 1) return sourceString;

	var numbers = String(sourceString).split(".");
	var naturalNumber = numbers[0];
	var decimalNumber = numbers.length > 1 ? "." + numbers[1] : "";

	var regularExpression = /(\d+)(\d{3})/;
	while( regularExpression.test(naturalNumber)) {
		naturalNumber = naturalNumber.replace(regularExpression, "$1" + "," + "$2");
	}

	return naturalNumber + decimalNumber;
};

StringUtil.convertTagListToString = function(tags) {
	if (!tags || tags.length < 1) return "";
	
	var tagString = "";

	var tagLength = tags.length;
	for (var idx = 0; idx < tagLength; idx++) {
		var tag = tags[idx];

		if (idx != 0) {
			tagString = " " + tagString;
		}
		tagString = tagString + tag.name;
	}

	return tagString;
};

StringUtil.toNumber = function(targetStr) {
	var target = StringUtil.trim(targetStr);
	
	return target.replace(/([^0-9])/g, "");	
};

/**
 * 로케이션 유틸
 */
function EgunLocationUtil() {}

/**
 * 이전 페이지로..
 */
EgunLocationUtil.gotoPrev = function() {
	history.back();
};

/**
 * url에서 파리미터 이름으로 파리미터 값 조회
 */
EgunLocationUtil.getParamValueByName = function(paramName) {
	var search = location.search.substring(1, location.length);
	var params = search.split("&");
	if (!params || params.length < 1) return "";

	var paramsLength = params;
	for (var idx = 0; idx < params.length; idx++) {
		var param = params[idx];

		var paramNameValue = param.split("=");
		var name = paramNameValue[0];
		var value = paramNameValue[1];

		if (paramName == name) {
			return value;
		}
	}
	return "";
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
	egun.sessionStorage.removeItem( EgunSessionStorage.Key_CURRENT_MONEYBOOK );
	
	$.cookie(EgunSessionStorage.KEY_AUTH_TOKEN, null);

	location.href="/auth/signin.html";
};






function DateUtil() {}

/**
 * YYYY-MM-DD현재 날짜 조회
 */
DateUtil.getCurrentDateYYYYMMDD = function() {
	var currentDate = new Date();
	
	var year = currentDate.getFullYear();
	var month = currentDate.getMonth() + 1;
	if (month < 10) {
		month = "0" + month;
	}
	var day = currentDate.getDate();
	if (day < 10) {
		day = "0" + day;
	}

	return year + "-" + month + "-" + day;
};

DateUtil.convertDashedYYYYMMDDToYYYYMMDD = function(dashedYYYYMMDD) {
	var dashedDate = StringUtil.toNumber(dashedYYYYMMDD);
	if (dashedDate.length != 8 ) {
		console.log("올바른 YYYY-MM-DD 날짜형태가 아닙니다. 문자열 : " + dashedYYYYMMDD);
		return dashedDate;
	}
	
	return dashedDate;
};

DateUtil.convertYYYYMMDDToDashedYYYYMMDD = function(yyyyMMdd) {
	var yyyyMMddDate = StringUtil.trim(yyyyMMdd);
	if (yyyyMMddDate.length != 8) {
		console.log("올바른 YYYY-MM-DD 날짜형태가 아닙니다. 문자열 : " + yyyyMMddDate);
		return yyyyMMddDate;
	}

	var year = yyyyMMddDate.substring(0, 4);
	var month = yyyyMMddDate.substring(4, 6);
	var day = yyyyMMddDate.substring(6, 8);

	return year + "-" + month + "-" + day;
};

DateUtil.convertYYYYmmdDToYYYYMMDDKorean = function(yyyyMMdd) {
	var yyyyMMddDate = StringUtil.trim(yyyyMMdd);
	if (yyyyMMddDate.length != 8) {
		console.log("올바른 YYYY-MM-DD 날짜형태가 아닙니다. 문자열 : " + yyyyMMddDate);
		return yyyyMMddDate;
	}

	var year = yyyyMMddDate.substring(0, 4);
	var month = yyyyMMddDate.substring(4, 6);
	var day = yyyyMMddDate.substring(6, 8);

	return year + "년 " + month + "월 " + day + "일";
};

DateUtil.addMonth = function(date, count) {
	if (!date || date.length != 8) return;
	
	var yyyy = Number(date.substring(0, 4));
	var mm = Number(date.substring(4, 6));
	var dd = Number(date.substring(6, 8));

	if (12 < mm + count) {
		yyyy++;
		mm = mm + count - 12;
	}
	else if (12 >= mm + count) {
		mm = mm + count;
	}
	if (mm < 10) {
		mm = "0" + mm;
	}
	return String(yyyy) + String(mm) + String(dd);
};

DateUtil.minusMonth = function(date, count) {
	if (!date || date.length != 8) return;
	
	var yyyy = Number(date.substring(0, 4));
	var mm = Number(date.substring(4, 6));
	var dd = Number(date.substring(6, 8));

	if (mm < count) {
		yyyy = yyyy - 1;
		mm = mm + 12 - count;
	}
	else if(mm == count) {
		yyyy = yyyy - 1;
		mm = 12;
	}
	else if (mm > count) {
		mm = mm - count;
	}

	if (mm < 10) {
		mm = "0" + mm;
	}

	return String(yyyy) + String(mm) + String(dd);
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
EgunSessionStorage.KEY_CURRENT_MONEYBOOK = "currentMoneyBook";

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

Array.prototype.contains = function (element) {
	for (var i = 0; i < this.length; i++) {
		if (this[i] == element) {
			return true;
		}
	}
	return false;
}