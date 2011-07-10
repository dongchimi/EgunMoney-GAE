package com.appspot.egun.money.ws.validator;

import com.appspot.egun.money.comp.utility.StringU;

public class SignInValidator
{
    public static boolean requeredSigninParams( String userEmail, String password )
    {
        if ( StringU.isEmptyOrNull( userEmail ) || StringU.isEmptyOrNull( password ) )
        {
            return false;
        }
        return true;
    }
}
