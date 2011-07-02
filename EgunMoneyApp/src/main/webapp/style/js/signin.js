function SignIn() {}

SignIn.userEmail_Click = function() {
	if (event.keyCode != 13) return;
	
	SignIn.signin_Click();
};

SignIn.password_Click = function() {
	if (event.keyCode != 13) return;
	
	SignIn.signin_Click();
};

SignIn.signin_Click = function(){
	var userEmail = $("#signin_userEmail").val();
	var password = $("#signin_password").val();
	if (StringUtil.isEmpty( userEmail )) return alert("이름 또는 이메일을 입력해주세요.");
	if (StringUtil.isEmpty( password )) return alert("비밀번호를 입력해주세요.");
		
	var url = "/ws/auth/signin";
	var params = {
			"userEmail" : userEmail, 
			"password" : password
	};
	
	post(url, params, signInCallback);
}

function signInCallback(jsonResponse) {
	location.href="/accountBook/getAccountBooks";
}