package com.appspot.egun.money.comp.utility;

public class NU
{
    public static int getInt( String str )
    {
        int i = -1;
        try
        {
            i = Integer.valueOf( str );
        }
        catch ( NumberFormatException e )
        {
        }

        return i;
    }

    public static int getInt( Long l )
    {
        if ( l == null )
            return 0;

        return l.intValue();
    }

    public static Long getLong( String str )
    {
        long l = 0;
        try
        {
            l = Long.valueOf( str );
        }
        catch ( NumberFormatException e )
        {
        }
        return l;
    }
}
