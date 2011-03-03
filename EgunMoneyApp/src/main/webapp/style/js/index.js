function signin() {
	var url = "/ws/auth/signin";
	var params = {
			userEmail : $("userEmail").val(), 
			password : $("password").val()
	};
	
	$.post(url, params, signInCallback);
}

function signInCallback(response) {
	var jsonResponse = response[0];
	var statusCode = jsonResponse.statusCode;
	// TODO 왜 리스트로 넘어올까?
	// 공통으로 분리할 것
	if (statusCode == "99") {
		var errorMessage = jsonResponse.message1;
		alert(errorMessage);
		return;
	}
	
	var resObj = jsonResponse.resObj;
	alert(resObj);
}