package com.appspot.egun.money.ws.moneybook;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appspot.egun.money.comp.domain.EgunUser;
import com.appspot.egun.money.comp.domain.MoneyBook;
import com.appspot.egun.money.comp.process.EgunUserProcess;
import com.appspot.egun.money.comp.process.MoneyBookProcess;
import com.appspot.egun.money.comp.utility.JSONResponse;
import com.appspot.egun.money.comp.utility.ResponseBuilder;
import com.sun.jersey.spi.resource.Singleton;

@Component("MoneyBookResourceWS")
@Singleton
@Path("/ws/moneyBook")
public class MoneyBookResource {
	
	@Autowired
	private EgunUserProcess egunUserProcess;
	
	@Autowired
	private MoneyBookProcess moneyBookItemProcess;
	
	@POST
	@Path("/getMoneyBooks")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONResponse getMoneyBooks(@FormParam("authToken") String authToken) {
		EgunUser loginUser = egunUserProcess.getUserByAuthToken(authToken);
		if (loginUser == null) {
			return ResponseBuilder.buildFailResponse("토큰에 해당하는 사용자가 존재하지 않습니다.");
		}

		List<MoneyBook> foundBooks = moneyBookItemProcess.findMoneyBookByUserEmail(loginUser.getUserEmail());
		return ResponseBuilder.buildSuccessResponse(foundBooks);
	}
	
	@GET
	@Path("/getDefaultMoneyBook")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONResponse getDefaultMoneyBook() {
		//EgunUser loginUser = SessionManager.getLoginUser(request);

		//MoneyBook foundBook = moneyBookItemProcess.findDefaultMoneyBookByUserEmail(loginUser.getUserEmail());
		//return ResponseBuilder.buildSuccessResponse(foundBook);
		return null;
	}
}