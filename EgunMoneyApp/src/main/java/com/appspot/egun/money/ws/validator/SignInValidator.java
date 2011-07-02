package com.appspot.egun.money.ws.validator;

import com.appspot.egun.money.comp.utility.SU;

public class SignInValidator
{
    public static boolean requeredSigninParams( String userEmail, String password )
    {
        if ( SU.isEmptyOrNull( userEmail ) || SU.isEmptyOrNull( password ) )
        {
            return false;
        }
        return true;
    }
}
