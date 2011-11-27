package com.appspot.egun.money.comp.process.logic;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appspot.egun.money.comp.domain.EgunTag;
import com.appspot.egun.money.comp.domain.MoneyBookItem;
import com.appspot.egun.money.comp.process.MoneyBookItemProcess;
import com.appspot.egun.money.comp.service.ContentTagService;
import com.appspot.egun.money.comp.service.MoneyBookItemService;
import com.appspot.egun.money.comp.service.MoneyBookService;

@Component
public class MoneyBookItemProcessLogic implements MoneyBookItemProcess {
	
	/** 로거 */
	private static final Logger logger = Logger.getLogger(MoneyBookItemProcessLogic.class.getSimpleName());

	@Autowired
	private MoneyBookService bookService;

	@Autowired
	private MoneyBookItemService itemService;

	@Autowired
	private ContentTagService tagService;

	@Override
	public Long registerMoneyBookItem(MoneyBookItem item, List<EgunTag> tags) {
		List<Long> tagOids = null;
		if (tags != null && !tags.isEmpty()) {
			tagOids = tagService.registerContentTags(tags);
			item.setTagOids(tagOids);
		}

		Long itemOid = itemService.registerAccountBookItem(item);
		return itemOid;
	}

	@Override
	public void modifyMoneyBookItem(MoneyBookItem item, List<EgunTag> tags) {
		List<Long> tagOids = null;
		if (tags != null && !tags.isEmpty()) {
			tagOids = tagService.registerContentTags(tags);
			item.setTagOids(tagOids);
		}
		
		itemService.modifyAccountBookItem(item);
	}

	@Override
	public List<MoneyBookItem> findMoneyBookItemsByTerm(long bookId, String startDay, String endDay) {
		List<MoneyBookItem> foundAccountItems = itemService.findMoneyBookItemsByTerm(bookId, startDay, endDay);
		for (MoneyBookItem item : foundAccountItems) {
			List<EgunTag> tags = tagService.findEgunTagsByOid(item.getTagOids());
			item.setRelatedTags(tags);
		}
		return foundAccountItems;
	}

	@Override
	public boolean removeMonthMoneyBookItems(long itemOid) {
		// item 을 조회
		MoneyBookItem bookItem = itemService.getMoneyBookItem(itemOid);
		if (bookItem == null) return false;
		
		logger.log(Level.ALL, "item 조회 :" + bookItem);
		
		List<Long> tagOids = bookItem.getTagOids();
		if (tagOids != null && tagOids.size() > 0) {
			logger.log(Level.ALL, "조회한 태그 : " + tagOids);
			
			for (Long tagOid : tagOids) {
				// 태그가 다른 item에서 사용중인가?
				// TODO 태그 사용
				boolean using = tagService.isUsingEgunTag(tagOid, itemOid);
				// 안 사용중이면 삭제
				if (!using) {
					tagService.removeEgunTag(tagOid);
				}
			}
		}
		
		// item 삭제
		itemService.removeMoneyBookItem(itemOid);
		
		return true;
	}

	@Override
	public MoneyBookItem getMoneyBookItem(String moneyBookItemId) {
		MoneyBookItem foundMoneyBookItem = itemService.getMoneyBookItem( Long.parseLong(moneyBookItemId) );
		if (foundMoneyBookItem != null) {
			// 태그
			List<Long> tagOids = foundMoneyBookItem.getTagOids();
			if (tagOids != null && tagOids.size() > 0) {
				logger.log(Level.ALL, "조회한 태그 : " + tagOids);
				
				List<EgunTag> tags = tagService.findEgunTagsByOid(foundMoneyBookItem.getTagOids());
				foundMoneyBookItem.setRelatedTags(tags);
			}
			
			// 자산
		}
		return foundMoneyBookItem;
	}

}
