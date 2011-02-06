package com.appspot.egun.money.ws.account;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appspot.egun.money.domain.AccountItem;
import com.appspot.egun.money.process.AccountItemProcess;
import com.appspot.egun.money.utility.JSONResponse;
import com.appspot.egun.money.utility.ResponseBuilder;
import com.google.appengine.api.datastore.Key;
import com.sun.jersey.spi.resource.Singleton;

@Component
@Singleton
@Path("/{userEmail}/accountItem")
public class AccountItemResource {
	
	@Autowired
	private AccountItemProcess accountItemProcess;
	
	@GET
	@Path("/register")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONResponse register(@FormParam("useDate") String useDate,
								 @FormParam("amount") long amount,
								 @FormParam("categoryOid") String categoryOid,
								 @FormParam("targetOid") String targetOid,
								 @FormParam("assetOid") String assetOid,
								 @FormParam("description") String description,
								 @FormParam("tags") String tags,
								 @FormParam("photo") byte[] photo,
								 @FormParam("installmentPlan") int installmentPlan) {
		
		AccountItem item = new AccountItem();
		item.setUseDate(useDate);
		item.setAmount(amount);
		
		// TODO ¿Ãµø±‘
//		item.setCategoryOid(categoryOid);
//		item.setTargetOid(targetOid);
//		item.setAssetOid(assetOid);

		item.setDescription(description);
		item.setTagString(tags);
		item.setPhoto(photo);
		item.setInstallmentPlan(installmentPlan);
		
		Key oid = accountItemProcess.registerAccountBookItem(item);
		item.setOid(oid);
		return ResponseBuilder.buildSuccessResponse(item);
	}
}
