$(document).ready(function() {
	Assets.getAssets();
});

function Assets() {}

/**
 * 내 자산목록 조회
 */
Assets.getAssets = function() {
	var url = "/ws/asset/asset/getAssets";
	
	var signinId = SigninUtil.getSigninId();
	var params = {
		"signinId" : signinId
	};
	egun.httpClient.post(url, params, Assets.getAssetsCallback);
};

Assets.getAssetsCallback = function( foundUserAsset ) {
	console.log(foundUserAsset);
	
	var $targetArea = $("#assets").empty();
	
	var assets = foundUserAsset.assets;
	for (var idx = 0; idx < assets.length; idx++) {
		var asset = assets[idx];
		
		$targetArea.append("<li><h3><a href='javascript:;' onclick='Assets.showAsset_Click(" + asset.oid.id + ")' >" + asset.name + "</a></h3></li>");
	}
	$targetArea.listview("refresh");
};

Assets.showAsset_Click = function( assetOid ) {
	alert(assetOid);
};