function NewAsset() {
}

/** 새로운 자산 등록 */
NewAsset.registerAsset_Click = function() {
	var assetType = $("#assetType").val();
	var assetName = $("#assetName").val();


	var currentSigninId = egun.sessionStorage.getItem( EgunSessionStorage.KEY_SIGNIN_ID );

	console.log(assetType);
	console.log(assetName);
	console.log(currentSigninId);
};

NewAsset.registerAsset_Keypress = function() {
	if (event.keyCode != 13) return;

	NewAsset.registerAsset_Click();
};