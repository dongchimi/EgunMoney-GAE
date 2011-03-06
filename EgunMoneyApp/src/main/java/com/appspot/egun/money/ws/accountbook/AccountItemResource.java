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

import com.appspot.egun.money.comp.domain.AccountItem;
import com.appspot.egun.money.comp.domain.AccountItemDivistion;
import com.appspot.egun.money.comp.domain.ContentTag;
import com.appspot.egun.money.comp.process.AccountItemProcess;
import com.appspot.egun.money.comp.utility.JSONResponse;
import com.appspot.egun.money.comp.utility.NU;
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
	
	@POST
	@Path("/register")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONResponse register(@FormParam("moneyDivision") String moneyDivision,
								 @FormParam("useDate") String useDate,
								 @FormParam("because") String because,
								 @FormParam("amount") String amount,
								 @FormParam("categoryOid") String categoryOid,
								 @FormParam("targetOid") String targetOid,
								 @FormParam("assetOid") String assetOid,
								 @FormParam("description") String description,
								 @FormParam("installmentPlan") String installmentPlan,
								 @FormParam("tags") String tags) {
		
		long bookId = SessionManager.getCurrentAccountBookId(request);
		
		AccountItem item = new AccountItem();
		item.setAccountBookId(bookId);
		item.setMoneyDivsition(AccountItemDivistion.valueOf(moneyDivision));
		item.setUseDate(useDate);
		item.setBecause(because);
		item.setAmount( NU.getLong(amount) );
		
		// TODO 이동규
		item.setCategoryOid( NU.getLong(categoryOid) );
		item.setTargetOid( NU.getLong(targetOid) );
		item.setAssetOid( NU.getLong(assetOid) );
		item.setDescription(description);
		item.setInstallmentPlan( NU.getInt(installmentPlan) );
		
		Long oid = accountItemProcess.registerAccountBookItem(item, ContentTag.getTagString(tags) );
		item.setOid(oid);
		
		return ResponseBuilder.buildSuccessResponse(item);
	}
	
//	@POST
//	@Path("/registerAccountItem")
//	@Produces(MediaType.APPLICATION_JSON)
//	public JSONResponse registerAccountItem(@FormParam("moneyDivision") String moneyDivision,
//											 @FormParam("useDate") String useDate,
//											 @FormParam("because") String because,
//											 @FormParam("amount") long amount,
//											 @FormParam("categoryOid") Long categoryOid,
//											 @FormParam("targetOid") Long targetOid,
//											 @FormParam("assetOid") Long assetOid,
//											 @FormParam("description") String description,
//											 @FormParam("installmentPlan") int installmentPlan,
//											 @FormParam("tags") String tags,
//											 @FormParam("photo") byte[] photo) {
//		
//		AccountItem item = new AccountItem();
//		item.setMoneyDivsition(AccountItemDivistion.valueOf(moneyDivision));
//		item.setUseDate(useDate);
//		item.setBecause(because);
//		item.setAmount(amount);
//		
//		// TODO 이동규
////		item.setCategoryOid(categoryOid);
////		item.setTargetOid(targetOid);
////		item.setAssetOid(assetOid);
////		item.setAssetOid(assetOid);
//		item.setDescription(description);
//		item.setInstallmentPlan(installmentPlan);
//		item.setTagString(tags);
//		item.setPhoto(photo);
//		
//		Long oid = accountItemProcess.registerAccountBookItem(item);
//		item.setOid(oid);
//		
//		return ResponseBuilder.buildSuccessResponse(item);
//	}
}
