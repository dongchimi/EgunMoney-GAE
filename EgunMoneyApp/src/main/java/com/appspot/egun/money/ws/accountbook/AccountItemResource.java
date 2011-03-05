package com.appspot.egun.money.ws.accountbook;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appspot.egun.money.comp.domain.AccountItem;
import com.appspot.egun.money.comp.process.AccountItemProcess;
import com.appspot.egun.money.comp.utility.JSONResponse;
import com.appspot.egun.money.comp.utility.ResponseBuilder;
import com.appspot.egun.money.comp.utility.SessionManager;
import com.sun.jersey.spi.resource.Singleton;

@Component("AccountItemResourcWS")
@Singleton
@Path("/ws/accountItem")
public class AccountItemResource {
	
	@Autowired
	private AccountItemProcess accountItemProcess;
	
	@Context
	private HttpServletRequest request;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/findThisMonthAccountItems")
	public JSONResponse findThisMonthAccountItems() {
		long currentBookId = SessionManager.getCurrentAccountBookId(request);
		
		List<AccountItem> foundItems = accountItemProcess.findThisMonthAccountItems(currentBookId);
		
		return ResponseBuilder.buildSuccessResponse(foundItems);
	}
	
//	@GET
//	@Path("/register")
//	@Produces(MediaType.APPLICATION_JSON)
//	public JSONResponse register(@FormParam("useDate") String useDate,
//								 @FormParam("amount") long amount,
//								 @FormParam("categoryOid") String categoryOid,
//								 @FormParam("targetOid") String targetOid,
//								 @FormParam("assetOid") String assetOid,
//								 @FormParam("description") String description,
//								 @FormParam("tags") String tags,
//								 @FormParam("photo") byte[] photo,
//								 @FormParam("installmentPlan") int installmentPlan) {
//		
//		AccountItem item = new AccountItem();
//		item.setUseDate(useDate);
//		item.setAmount(amount);
//		
//		// TODO ¿Ãµø±‘
////		item.setCategoryOid(categoryOid);
////		item.setTargetOid(targetOid);
////		item.setAssetOid(assetOid);
//
//		item.setDescription(description);
//		item.setTagString(tags);
//		item.setPhoto(photo);
//		item.setInstallmentPlan(installmentPlan);
//		
//		Key oid = accountItemProcess.registerAccountBookItem(item);
//		item.setOid(oid);
//		return ResponseBuilder.buildSuccessResponse(item);
//	}
}
