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
	
	/** �ΰ� */
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
		// item �� ��ȸ
		MoneyBookItem bookItem = itemService.getMoneyBookItem(itemOid);
		if (bookItem == null) return false;
		
		logger.log(Level.ALL, "item ��ȸ :" + bookItem);
		
		List<Long> tagOids = bookItem.getTagOids();
		if (tagOids != null && tagOids.size() > 0) {
			logger.log(Level.ALL, "��ȸ�� �±� : " + tagOids);
			
			for (Long tagOid : tagOids) {
				// �±װ� �ٸ� item���� ������ΰ�?
				// TODO �±� ���
				boolean using = tagService.isUsingEgunTag(tagOid, itemOid);
				// �� ������̸� ����
				if (!using) {
					tagService.removeEgunTag(tagOid);
				}
			}
		}
		
		// item ����
		itemService.removeMoneyBookItem(itemOid);
		
		return true;
	}

	@Override
	public MoneyBookItem getMoneyBookItem(String moneyBookItemId) {
		MoneyBookItem foundMoneyBookItem = itemService.getMoneyBookItem( Long.parseLong(moneyBookItemId) );
		if (foundMoneyBookItem != null) {
			// �±�
			List<Long> tagOids = foundMoneyBookItem.getTagOids();
			if (tagOids != null && tagOids.size() > 0) {
				logger.log(Level.ALL, "��ȸ�� �±� : " + tagOids);
				
				List<EgunTag> tags = tagService.findEgunTagsByOid(foundMoneyBookItem.getTagOids());
				foundMoneyBookItem.setRelatedTags(tags);
			}
			
			// �ڻ�
		}
		return foundMoneyBookItem;
	}

}
