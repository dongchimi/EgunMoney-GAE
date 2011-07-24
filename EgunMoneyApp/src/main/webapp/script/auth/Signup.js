/**
 * 회원가입
 */
function Signup() {}

Signup.register = function() {
	var $userEmailInput = $("#registerForm :input[name=userEmail]");
	var $passwordInput = $("#registerForm :input[name=password]");
	var $nickNameInput = $("#registerForm :input[name=nickName]");
	
	var userEmail = $userEmailInput.val();
	var password = $passwordInput.val();
	var nickName = $nickNameInput.val();
	
	if (StringUtil.isEmpty( userEmail )) {
		alert("이름 또는 이메일을 입력해주세요.");
		return $userEmailInput.focus();
	}
	if (StringUtil.isEmpty( password )) {
		alert("비밀번호를 입력해주세요.");
		return $passwordInput.focus();
	}
	if (StringUtil.isEmpty( nickName )) {
		alert("닉네임을 입력해부세요.");
		return $nickNameInput.focus()
	}
	
	var url = "/ws/auth/signup/register";
	var params = {
			"userEmail" : userEmail,
			"password" : password,
			"nickName" : nickName
	};
	
	egun.httpClient.post(url, params, Signup.register_Callback);
};

Signup.register_Callback = function(jsonResponse) {
	alert("회원가입이 완료되었습니다. 내 가계부 목록으로 이동합니다.");
	
	SigninUtil.setSiginId( jsonResponse.userEmail );
	SigninUtil.setAuthToken( jsonResponse.authToken );
	
	location.href="/moneyBook/moneyBooks.html";
};