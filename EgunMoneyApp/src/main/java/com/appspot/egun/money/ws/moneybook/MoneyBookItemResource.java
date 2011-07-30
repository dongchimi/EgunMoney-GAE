package com.appspot.egun.money.ws.moneybook;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appspot.egun.money.comp.process.MoneyBookItemProcess;
import com.appspot.egun.money.comp.utility.JSONResponse;
import com.appspot.egun.money.comp.utility.ResponseBuilder;
import com.sun.jersey.spi.resource.Singleton;

@Component("MoneyBookItemResourceWS")
@Singleton
@Path("/ws/moneyBookItem")
public class MoneyBookItemResource {

	@Autowired
	private MoneyBookItemProcess moneyBookItemProcess;

	/**
	 * TODO authToken으로 인증할것!!
	 * */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/findThisMonthMoneyBookItems")
	public JSONResponse findThisMonthMoneyBookItems(@FormParam("moneyBookId") Long moneyBookId) {
		//List<MoneyBookItem> foundItems = moneyBookItemProcess.findThisMonthMoneyBookItems(moneyBookId);
		return ResponseBuilder.buildSuccessResponse(null);
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
		
//		MoneyBookItem item = new MoneyBookItem();
//		item.setAccountBookId(bookId);
//		item.setMoneyDivsition(InOut.valueOf(moneyDivision));
//		item.setUseDate(useDate);
//		item.setBecause(because);
//		item.setAmount(NumberU.getLong(amount));
//
//		item.setCategoryOid(NumberU.getLong(categoryOid));
//		item.setTargetOid(NumberU.getLong(targetOid));
//		item.setAssetOid(NumberU.getLong(assetOid));
//		item.setDescription(description);
//		item.setInstallmentPlan(NumberU.getInt(installmentPlan));
//
//		Long oid = moneyBookItemProcess.registerMoneyBookItem(item, EgunTag.getTagString(tags));
//		item.setOid(oid);

		return ResponseBuilder.buildSuccessResponse(null);
	}
}
