package com.appspot.egun.money.app.accountbook;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import org.springframework.stereotype.Component;

import com.appspot.egun.money.comp.utility.SessionManager;
import com.sun.jersey.api.view.Viewable;
import com.sun.jersey.spi.resource.Singleton;

@Component("AccountBookResourceApp")
@Singleton
@Path("/accountBook")
public class AccountBookResource
{

    @Context
    private HttpServletRequest request;

    @GET
    @Path("/getAccountBooks")
    @Produces("text/html")
    public Viewable getAccountBooks()
    {
        if ( !SessionManager.isLogin( request ) )
        {
            return null;
        }

        return new Viewable( "/accountBook/accountBooks.html" );
    }
}
