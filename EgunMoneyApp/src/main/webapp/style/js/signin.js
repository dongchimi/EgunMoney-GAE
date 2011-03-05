function signin() {
	var url = "/ws/auth/signin";
	var params = {
			userEmail : $("#signin_userEmail").val(), 
			password : $("#signin_password").val()
	};	
	
	post(url, params, signInCallback);
}

function signInCallback(jsonResponse) {
	var userEmail = jsonResponse.resObj.userEmail;
	location.href="/accountBook/" + userEmail + "/getAccountBooks";
}

function signup() {
	var url = "/ws/signup/register";
	var params = {
			nickName : $("#signup_nickName").val(),
			userEmail : $("#signup_userEmail").val(),
			password : $("#signup_password").val()
	};
	
	post(url, params, signupCallback);
}

function signupCallback(response) {
	var goLogin = confirm("회원가입이 완료되었습니다. 바로 로그인 할까요?"); 
	var resObj = response.resObj;
	if (goLogin) {
		signupAfterSignin();
	} else {
		location.href="/index";
	}
}

function signupAfterSignin() {
	var url = "/ws/auth/signin";
	var params = {
			userEmail : $("#signup_userEmail").val(), 
			password : $("#signup_password").val()
	};	
	
	post(url, params, signInCallback);
}