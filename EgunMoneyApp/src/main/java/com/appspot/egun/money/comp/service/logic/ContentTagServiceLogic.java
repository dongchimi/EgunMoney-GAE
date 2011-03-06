package com.appspot.egun.money.comp.service.logic;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;

import org.springframework.stereotype.Component;

import com.appspot.egun.money.comp.domain.ContentTag;
import com.appspot.egun.money.comp.service.ContentTagService;
import com.appspot.egun.money.comp.utility.PMFProvider;

@Component
public class ContentTagServiceLogic implements ContentTagService {
	
	private PersistenceManager pm = null;
	
	@Override
	public Long registerContentTag(ContentTag tag) {
		try {
			pm = PMFProvider.get().getPersistenceManager();
			pm.makePersistent(tag);
		} finally {
			if(!pm.isClosed()) {
				pm.close();
			}
		}
		return tag.getOid();
	}

	@Override
	public List<Long> registerContentTags(List<ContentTag> tags) {
		List<Long> oids = new ArrayList<Long>();
		
		for (ContentTag tag : tags) {
			Long oid = registerContentTag(tag);
			oids.add( oid );
		}
		
		return oids;
	}
}
