/**
 * 로그인
 */
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
	
	location.href="/moneyBook/moneyBooks.html";
};