package com.appspot.egun.money.ws.moneybook;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appspot.egun.money.comp.domain.EgunTag;
import com.appspot.egun.money.comp.domain.InOutTransfer;
import com.appspot.egun.money.comp.domain.MoneyBook;
import com.appspot.egun.money.comp.domain.MoneyBookItem;
import com.appspot.egun.money.comp.process.MoneyBookItemProcess;
import com.appspot.egun.money.comp.process.MoneyBookProcess;
import com.appspot.egun.money.comp.utility.DateU;
import com.appspot.egun.money.comp.utility.JSONResponse;
import com.appspot.egun.money.comp.utility.NumberU;
import com.appspot.egun.money.comp.utility.ResponseBuilder;
import com.appspot.egun.money.comp.utility.StringU;
import com.appspot.egun.money.ws.dto.StartEndDateDto;
import com.appspot.egun.money.ws.dto.StartEndDateWidthMoneyBookItemsDto;
import com.sun.jersey.spi.resource.Singleton;

@Component("MoneyBookItemResourceWS")
@Singleton
@Path("/ws/moneyBookItem")
public class MoneyBookItemResource {

	@Autowired
	private MoneyBookItemProcess moneyBookItemProcess;
	
	@Autowired
	private MoneyBookProcess moneyBookProcess;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/findMoneyBookItemsByTerm")
	public JSONResponse findMoneyBookItemsByTerm(@FormParam("moneyBookId") Long moneyBookId,
													@FormParam("startDay") String startDay,
													@FormParam("endDay") String endDay) {
		
		StartEndDateDto startEndDate = new StartEndDateDto();
		if (StringU.isEmptyOrNull(startDay)) {
			MoneyBook foundMoneyBook = moneyBookProcess.getMoneyBook( moneyBookId );
			String baseDay = "";
			if (foundMoneyBook != null) {
				baseDay = foundMoneyBook.getBaseDay();
			}
			
			startEndDate.setStartEndBaseDayByToday(DateU.getCurrentDateString(), baseDay);
			startDay = startEndDate.getStartDay();
			endDay = startEndDate.getEndDay();
		}
		else {
			startEndDate.setStartDay(startDay);
			startEndDate.setEndDay(endDay);
		}
		
		List<MoneyBookItem> foundItems = moneyBookItemProcess.findMoneyBookItemsByTerm(moneyBookId, startDay, endDay);
		return ResponseBuilder.buildSuccessResponse( new StartEndDateWidthMoneyBookItemsDto(startEndDate, foundItems) );
	}

	@POST
	@Path("/register")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONResponse register(
								@FormParam("moneyBookItemOid") String moneyBookItemOid,
								@FormParam("bookId") String bookId,
								@FormParam("moneyDivision") String moneyDivision,
								@FormParam("useDate") String useDate, 
								@FormParam("content") String content,
								@FormParam("amount") String amount, 
								@FormParam("description") String description, 
								@FormParam("tags") String tags) {
		
		MoneyBookItem item = new MoneyBookItem();
		item.setAccountBookId(NumberU.getLong(bookId));
		item.setInOutTransfer(InOutTransfer.valueOf(moneyDivision));
		item.setUseDate(useDate);
		item.setContent(content);
		item.setDescription(description);
		item.setAmount(NumberU.getLong(amount));
		
		if(moneyBookItemOid != null && moneyBookItemOid.length() > 0) {
			item.setOid(NumberU.getLong(moneyBookItemOid));
			moneyBookItemProcess.modifyMoneyBookItem(item, EgunTag.convertTagStringToList(tags));
		}
		else {
			Long oid = moneyBookItemProcess.registerMoneyBookItem(item, EgunTag.convertTagStringToList(tags));
			item.setOid(oid);
		}
		
		return ResponseBuilder.buildSuccessResponse(item);
	}
	
	@POST
	@Path("/getMonthMoneyBookItem")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONResponse getMonthMoneyBookItem(@FormParam("moneyBookItemId") String moneyBookItemId) {
		MoneyBookItem bookItem = moneyBookItemProcess.getMoneyBookItem(moneyBookItemId);
		
		return ResponseBuilder.buildSuccessResponse(bookItem);
	}
	
	@POST
	@Path("/removeMonthMoneyBookItems")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONResponse removeMonthMoneyBookItems(@FormParam("moneyBookItemId") String moneyBookItemId) {
		
		moneyBookItemProcess.removeMonthMoneyBookItems( NumberU.getInt(moneyBookItemId) );
		
		return ResponseBuilder.buildSuccessResponse("");
	}
}