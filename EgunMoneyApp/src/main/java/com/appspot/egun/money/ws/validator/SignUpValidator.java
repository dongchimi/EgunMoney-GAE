package com.appspot.egun.money.ws.validator;

import com.appspot.egun.money.comp.utility.StringU;

public class SignUpValidator {

	public static boolean hasRequiredSingupParams(String nickName, String userEmail, String password) {
		if (StringU.isEmptyOrNull(nickName) || StringU.isEmptyOrNull(userEmail) || StringU.isEmptyOrNull(password)) {
			return false;
		}

		return true;
	}
}
