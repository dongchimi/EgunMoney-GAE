var callback;

function get(url, params, cb) {
	callback = cb;
	
	$.mobile.pageLoading();
	$.get(url, params, postGetCallback, "json");
}

function post(url, params, cb) {
	callback = cb;
	
	$.mobile.pageLoading( false );
	$.post(url, params, postGetCallback, "json");
}

function postGetCallback(response) {
	$.mobile.pageLoading( true );
	
	var jsonResponse = response[0];
	var statusCode = jsonResponse.statusCode;
	if (statusCode == "99") {
		var errorMessage = jsonResponse.message1;
		alert(errorMessage);
		return;
	}
	
	callback(jsonResponse);
}