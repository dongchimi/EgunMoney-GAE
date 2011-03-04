package com.appspot.egun.money.ws.validator;

import com.appspot.egun.money.comp.utility.SU;

public class SignUpValidator {
	
	public static boolean hasRequiredSingupParams(String nickName, String userEmail, String password) {
		
		if (SU.isEmptyOrNull(nickName) || SU.isEmptyOrNull(userEmail) || SU.isEmptyOrNull(password)) {
			return false;
		}
		
		return true;
	}
}
