package com.appspot.egun.money.comp.utility.json;

import java.util.Date;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import com.appspot.egun.money.comp.utility.DateU;

public class DateJsonValuerocessor
    implements JsonValueProcessor
{

    @Override
    public Object processArrayValue( Object value, JsonConfig jsonConfig )
    {
        return process( value, jsonConfig );
    }

    @Override
    public Object processObjectValue( String key, Object value, JsonConfig jsonConfig )
    {
        return process( value, jsonConfig );
    }

    private Object process( Object value, JsonConfig jsonConfig )
    {
        if ( !( value instanceof Date ) )
            return null;

        return DateU.convertFormat( (Date) value );
    }
}
