package com.appspot.egun.money.ws.validator;

import com.appspot.egun.money.comp.utility.SU;

public class SignInValidator {
	public static boolean validSigninParams(String userEmail, String password) {
		if (SU.isEmptyAndNull(userEmail)) {
			return false;
		}
		return true;
	}
}
