package com.appspot.egun.money.ws.account;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appspot.egun.money.comp.domain.AccountBook;
import com.appspot.egun.money.comp.domain.EgunUser;
import com.appspot.egun.money.comp.process.AccountBookProcess;
import com.appspot.egun.money.comp.utility.JSONResponse;
import com.appspot.egun.money.comp.utility.ResponseBuilder;
import com.appspot.egun.money.comp.utility.SessionManager;
import com.google.appengine.api.datastore.Key;
import com.sun.jersey.spi.resource.Singleton;

@Component
@Singleton
@Path("/{userEmail}/accountBook")
public class AccountBookResource {
	
	@Autowired
	private AccountBookProcess accountItemProcess;

	@Context
	private HttpServletRequest request;
	
	@GET
	@Path("/register")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONResponse register(@FormParam("accountBookName") String accountBookName,
								 @FormParam("baseDay") String baseDay ) {
		
		EgunUser loginUser = SessionManager.getLoginUser(request);
		
		AccountBook book = new AccountBook(loginUser, accountBookName);
		Key oid = null;
		try {
			oid = accountItemProcess.reigsterAccountBook(book);
			
			// 권한처리
			
		} catch (Exception e) {
			return ResponseBuilder.buildFailResponse(e);
		}
		
		book.setOid(oid);
		return ResponseBuilder.buildSuccessResponse(book);
	}
	
	@GET
	@Path("/getAccountBooks")
	@Produces()
	public JSONResponse getAccountBooks() {
		EgunUser loginUser = SessionManager.getLoginUser(request);

		List<AccountBook> foundBooks = accountItemProcess.findAccountBookByUserEmail(loginUser.getUserEmail());
		return ResponseBuilder.buildSuccessResponse(foundBooks);
	}
	
	@GET
	@Path("/getDefaultAccountBook")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONResponse getDefaultAccountBook() {
		EgunUser loginUser = SessionManager.getLoginUser(request);
		
		AccountBook foundBook = accountItemProcess.findDefaultAccountBookByUserEmail(loginUser.getUserEmail());
		return ResponseBuilder.buildSuccessResponse(foundBook);
	}
}