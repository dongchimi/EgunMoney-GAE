/**
 * 로그인
 */

 $(document).ready(function(){
 	
 	// 자동로그인 되었는가?
 	var authToken = $.cookie(EgunSessionStorage.KEY_AUTH_TOKEN);
 	if( !StringUtil.isEmpty(authToken) ) {
 		Signin.signinByAutoToken(authToken);
 	}
 });

function Signin() {}

Signin.pressUserEmailPassword_Click = function() {
	if (event.keyCode != 13) return;
	
	Signin.signin_Click();
};

Signin.signin_Click = function() {
	var userEmail = $("#signin_userEmail").val();
	var password = $("#signin_password").val();
	if (StringUtil.isEmpty( userEmail )) {
		alert("이름 또는 이메일을 입력해주세요.");
		return $("#signin_userEmail").focus();
	}
	if (StringUtil.isEmpty( password )) {
		alert("비밀번호를 입력해주세요.");
		return $("#signin_password").focus();
	}
	
	var url = "/ws/auth/signin/signin";
	var params = {
			"userEmail" : userEmail, 
			"password" : password
	};
	
	egun.httpClient.post(url, params, Signin.signin_Callback);
};

Signin.signin_Callback = function(jsonResponse) {
	
	SigninUtil.setSiginId( jsonResponse.userEmail );
	SigninUtil.setAuthToken( jsonResponse.authToken );
	
	// 자동로그인
	var autoSignin = $("#autoSignin").val();
	if ("ON" == autoSignin) {
		$.cookie(EgunSessionStorage.KEY_AUTH_TOKEN, jsonResponse.authToken,  { expires: 1 });
	}
	else if ("OFF" == autoSignin) {
		$.cookie(EgunSessionStorage.KEY_AUTH_TOKEN, null);
	}

	location.href="/moneyBook/moneyBooks.html";
};

Signin.signinByAutoToken = function(authToken) {
	var url = "/ws/auth/signin/signinByAutoToken";
	var params = {
			"authToken" : authToken
	};
	
	egun.httpClient.post(url, params, Signin.signinByAutoToken_Callback);	
};

Signin.signinByAutoToken_Callback = function(response) {

	SigninUtil.setSiginId( response.userEmail );
	SigninUtil.setAuthToken( response.authToken );

	location.href="/moneyBook/moneyBooks.html";
};