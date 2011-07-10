/**
 * 로그인
 */
function Signin() {}

Signin.userEmail_Click = function() {
	if (event.keyCode != 13) return;
	
	Signin.signin_Click();
};

Signin.password_Click = function() {
	if (event.keyCode != 13) return;
	
	SignIn.signin_Click();
};

Signin.signin_Click = function(){
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
	
	var url = "/ws/auth/signin";
	var params = {
			"userEmail" : userEmail, 
			"password" : password
	};
	
	egun.httpClient.post(url, params, signInCallback);
};

function signInCallback(jsonResponse) {
	location.href="/accountBook/getAccountBooks";
};