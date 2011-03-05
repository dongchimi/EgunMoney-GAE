package com.appspot.egun.money.app.accountbook;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import org.springframework.stereotype.Component;

import com.appspot.egun.money.comp.domain.EgunUser;
import com.appspot.egun.money.comp.utility.SessionManager;
import com.sun.jersey.api.view.Viewable;
import com.sun.jersey.spi.resource.Singleton;

@Component("AccountItemResourceApp")
@Singleton
@Path("/accountItem")
public class AccountItemResource {
	
	@Context
	private HttpServletRequest request;
	
	@GET
	@Path("/findAccountItems")
	@Produces("text/html")
	public Viewable findAccountItems(@QueryParam("bookId") String bookId ) {
		// TODO 이동규  ACEGI 적용 후 걷어내기
		EgunUser loginUser = SessionManager.getLoginUser(request);
		if (loginUser == null) {
			return null;
		}
		
		return new Viewable("/accountBook/accountItemsByMonthly.html");
	}
}
