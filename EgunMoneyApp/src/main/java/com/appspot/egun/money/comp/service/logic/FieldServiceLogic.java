package com.appspot.egun.money.comp.service.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jdo.JDOFatalUserException;
import javax.jdo.PersistenceManager;

import org.springframework.stereotype.Component;

import com.appspot.egun.money.comp.domain.Field;
import com.appspot.egun.money.comp.service.FieldService;
import com.appspot.egun.money.comp.utility.PMFProvider;

@Component
public class FieldServiceLogic implements FieldService {

    /** 로거 */
    private final Logger logger = Logger.getLogger( FieldServiceLogic.class.getSimpleName() );

	private PersistenceManager pm = null;

	@Override
	public long registerField(Field field) {
		pm = PMFProvider.getPersistenceManager();
		
		try {
			pm.makePersistent(field);
		} catch (JDOFatalUserException e) {
			e.printStackTrace();
		} finally {
			if (!pm.isClosed()) {
				pm.close();
			}
		}
		
		logger.log(Level.WARNING, "필드 등록 oid : " + field.getOid());
		
		return field.getOid();
	}

	@Override
	public List<Long> registerFields(List<Field> fields) {
		List<Long> oids = new ArrayList<Long>();
		for (Field field : fields) {
			long fieldOid = registerField(field);
			oids.add(fieldOid);
		}
		return oids;
	}
}
