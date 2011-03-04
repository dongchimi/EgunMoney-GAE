package com.appspot.egun.money.app.account.resource;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appspot.egun.money.comp.domain.EgunUser;
import com.appspot.egun.money.comp.process.AccountBookProcess;
import com.appspot.egun.money.comp.utility.SessionManager;
import com.sun.jersey.api.view.Viewable;
import com.sun.jersey.spi.resource.Singleton;

@Component("AccountBookResourceApp")
@Singleton
@Path("/{userEmail}/accountBook")
public class AccountBookResource {
	
	@Autowired
	private AccountBookProcess accountItemProcess;

	@Context
	private HttpServletRequest request;
	
	@GET
	@Path("/getAccountBooks")
	@Produces()
	public Viewable getAccountBooks(@PathParam("userEmail") String userEmail) {
		// TODO 이동규  ACEGI 적용 후 걷어내기
		EgunUser loginUser = SessionManager.getLoginUser(request);
		if (loginUser == null) {
			return null;
		}
		
		return new Viewable("/accountBook/accountBooks.html");
	}
}
