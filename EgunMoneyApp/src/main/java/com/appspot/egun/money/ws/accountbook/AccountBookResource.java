package com.appspot.egun.money.ws.accountbook;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
import com.sun.jersey.spi.resource.Singleton;

@Component("AccountBookResourceWS")
@Singleton
@Path("/ws/accountBook")
public class AccountBookResource {
	
	@Autowired
	private AccountBookProcess accountItemProcess;

	@Context
	private HttpServletRequest request;
	
	@POST
	@Path("/register")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONResponse register(@FormParam("accountBookName") String accountBookName,
								 @FormParam("baseDay") String baseDay ) {
		
		EgunUser loginUser = SessionManager.getLoginUser(request);
		
		AccountBook book = new AccountBook(loginUser, accountBookName);
		Long oid = null;
		try {
			oid = accountItemProcess.reigsterAccountBook(book);
			
			// ����ó��
			
		} catch (Exception e) {
			return ResponseBuilder.buildFailResponse(e);
		}
		
		book.setOid(oid);
		return ResponseBuilder.buildSuccessResponse(book);
	}
	
	@GET
	@Path("/getAccountBooks")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONResponse getAccountBooks() {
		EgunUser loginUser = SessionManager.getLoginUser(request);
		if (loginUser == null) {
			return ResponseBuilder.buildEmptyResponse("�α����� ���� �ؾ� �մϴ�.");
		}
		
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