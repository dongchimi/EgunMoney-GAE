package com.appspot.egun.money.comp.service.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.springframework.stereotype.Component;

import com.appspot.egun.money.comp.domain.EgunTag;
import com.appspot.egun.money.comp.service.ContentTagService;
import com.appspot.egun.money.comp.utility.PMFProvider;

@Component
public class ContentTagServiceLogic implements ContentTagService {
	
	private PersistenceManager pm = null;
	
    /** 로거 */
    private static final Logger logger = Logger.getLogger( ContentTagServiceLogic.class.getSimpleName() );

	@Override
	public Long registerContentTag(EgunTag tag) {
		// 기존 태그가 존재하면 카운트만 +1 함
		
		EgunTag oldTag = getContentTagByName( tag.getName() );
		if (oldTag != null) {
			oldTag.addCount();
			tag = oldTag;
			
			logger.log(Level.ALL, "new tag : " + tag);
			logger.log(Level.ALL, "old tag : " + tag);
		} else {
			tag.setUsedCount(1);
		}
		
		pm = PMFProvider.get().getPersistenceManager();
		try {
			pm.makePersistent(tag);
		} finally {
			if (!pm.isClosed()) {
				pm.close();
			}
		}
		return tag.getOid();
	}
	
	@Override
	public List<Long> registerContentTags(List<EgunTag> tags) {
		List<Long> oids = new ArrayList<Long>();

		for (EgunTag tag : tags) {
			Long oid = registerContentTag(tag);
			oids.add(oid);
		}

		return oids;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public EgunTag getContentTagByName(String tagName){
		EgunTag foundTag = null;

		pm = PMFProvider.getPersistenceManager();

		try {
			Query getUserQuery = pm.newQuery(EgunTag.class, "name == nameParam");
			getUserQuery.declareParameters("String nameParam");

			List<EgunTag> foundTags = (List<EgunTag>) getUserQuery.execute(tagName);

			if (!foundTags.isEmpty()) {
				foundTag = foundTags.get(0);
			} else {
			}
		} catch (JDOObjectNotFoundException e) {
		} finally {
			pm.close();
		}

		return foundTag;
	}

	@Override
	public List<EgunTag> findEgunTagsByOid(List<Long> tagOids) {
		List<EgunTag> foundTags = new ArrayList<EgunTag>();
		
		for (Long oid : tagOids) {
			EgunTag tag = getEgunTagByOid(oid);
			if (tag != null) {
				foundTags.add(tag);
			}
		}
		
		return foundTags;
	}
	
	private EgunTag getEgunTagByOid(long oid) {
		EgunTag foundTag = null;
		
		pm = PMFProvider.getPersistenceManager();
		
		try {
			foundTag = (EgunTag) pm.getObjectById(EgunTag.class, oid);
		} catch (JDOObjectNotFoundException e) {
		} finally {
			pm.close();
		}
		
		return foundTag;
	}

	@Override
	public boolean isUsingEgunTag(Long tagOid, Long exceptBookItem) {
		
		EgunTag foundTag = getEgunTagByOid(tagOid);
		if (foundTag == null) return false;
		
		return foundTag.isUsing();
	}

	@Override
	public void removeEgunTag(Long tagOid) {
		
	}
}
