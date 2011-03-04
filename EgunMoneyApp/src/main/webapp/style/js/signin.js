function signin() {
	var url = "/ws/auth/signin";
	var params = {
			userEmail : $("#signin_userEmail").val(), 
			password : $("#signin_password").val()
	};	
	
	$.mobile.pageLoading();
	$.post(url, params, signInCallback);
}

function signInCallback(response) {
	$.mobile.pageLoading( true );
	
	var jsonResponse = response[0];
	var statusCode = jsonResponse.statusCode;
	// TODO 왜 리스트로 넘어올까?
	// 공통으로 분리할 것
	if (statusCode == "99") {
		var errorMessage = jsonResponse.message1;
		alert(errorMessage);
		return;
	}
	
	// 가계부 목록으로 넘어감
	var resObj = jsonResponse.resObj;
	var userEmail = resObj.userEmail;
	location.href="/" + userEmail + "/accountBook/getAccountBooks";
}

function signup() {
	var url = "/ws/signup/register";
	var params = {
			nickName : $("#signup_nickName").val(),
			userEmail : $("#signup_userEmail").val(),
			password : $("#signup_password").val()
	};
	$.mobile.pageLoading();
	$.post(url, params, signupCallback);
}

function signupCallback(response) {
	$.mobile.pageLoading( true );
	
	var jsonResponse = response[0];
	var statusCode = jsonResponse.statusCode;
	// TODO 왜 리스트로 넘어올까?
	// 공통으로 분리할 것
	if (statusCode == "99") {
		var errorMessage = jsonResponse.message1;
		alert(errorMessage);
		return;
	}
	var goLogin = confirm("회원가입이 완료되었습니다. 바로 로그인 할까요?"); 
	var resObj = jsonResponse.resObj;
	if (goLogin) {
		signin();
	} else {
		location.href="/index";
	}
}