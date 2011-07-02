package com.appspot.egun.money.utility.json;

import java.util.logging.Level;
import java.util.logging.Logger;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class JSONResponseValueProcessor
    implements JsonValueProcessor
{

    /** ·Î°Å */
    private static final Logger logger = Logger.getLogger( JSONResponseValueProcessor.class.getSimpleName() );

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
        logger.log( Level.WARNING, "JSONResponseValueProcessor call " + value );
        return JSONObject.fromObject( JSONSerializer.toJSON( value ) );
    }
}
