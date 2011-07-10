package com.appspot.egun.money.app.accountbook;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.springframework.stereotype.Component;

import com.sun.jersey.spi.resource.Singleton;

@Component("AccountItemResourceApp")
@Singleton
@Path("/accountItem")
public class AccountItemResource
{

    @Context
    private HttpServletRequest request;

//    @GET
//    @Path("/findAccountItems")
//    @Produces("text/html")
//    public Viewable findAccountItems( @QueryParam("bookId") String bookId )
//    {
//        // TODO 이동규  ACEGI 적용 후 걷어내기
//        if ( !SessionManager.isLogin( request ) )
//        {
//            return null;
//        }
//        // bookId가 있을때도 있고, 없을때도 있고..
//        if ( !StringU.isEmptyOrNull( bookId ) )
//        {
//            SessionManager.setAccountBookId( request, NumberU.getLong( bookId ) );
//        }
//
//        return new Viewable( "/accountBook/accountItemsByMonthly.html" );
//    }
//
//    @GET
//    @Path("/newAccountItem")
//    @Produces("text/html")
//    public Viewable newAccountItem()
//    {
//        // TODO 이동규  ACEGI 적용 후 걷어내기
//        if ( !SessionManager.isLogin( request ) )
//        {
//            return null;
//        }
//
//        return new Viewable( "/accountBook/newAccountItem.html" );
//    }
}
