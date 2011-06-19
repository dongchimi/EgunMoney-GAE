package com.appspot.egun.money.comp.utility;

import java.io.Serializable;

public class JSONResponse
    implements Serializable
{
    /** 정상 */
    public static final String STATUS_SUCCESS = "00";

    /** 오류 */
    public static final String STATUS_FAIL = "99";

    /** UID */
    private static final long serialVersionUID = -1435364192658455420L;

    /**
     * 결과코드
     */
    private String statusCode;

    private String message1;

    private String message2;

    private Object resObj;

    public JSONResponse( String statusCode )
    {
        this.statusCode = statusCode;
    }

    public String getStatusCode()
    {
        return statusCode;
    }

    public void setStatusCode( String statusCode )
    {
        this.statusCode = statusCode;
    }

    public String getMessage1()
    {
        return message1;
    }

    public void setMessage1( String message1 )
    {
        this.message1 = message1;
    }

    public String getMessage2()
    {
        return message2;
    }

    public void setMessage2( String message2 )
    {
        this.message2 = message2;
    }

    public Object getResObj()
    {
        return resObj;
    }

    public void setResObj( Object resObj )
    {
        this.resObj = resObj;
    }
}
