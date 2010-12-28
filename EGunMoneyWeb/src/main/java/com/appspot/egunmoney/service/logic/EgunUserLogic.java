package com.appspot.egunmoney.service.logic;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import org.springframework.stereotype.Component;

import com.appspot.egunmoney.constant.EgunMoneyConstant;
import com.appspot.egunmoney.domain.EgunUser;
import com.appspot.egunmoney.service.EgunUserService;

@Component
public class EgunUserLogic implements EgunUserService {
	
	private PersistenceManagerFactory pmfInstance = JDOHelper.getPersistenceManagerFactory(EgunMoneyConstant.PMFN);
	private PersistenceManager pm = null;
	
	@Override
	public long registerUser(EgunUser user) {
		try {
			getPM().makePersistent(user);
		} finally {
			if(!pm.isClosed()) {
				pm.close();
			}
		}
		return user.getOid().getId();
	}

	@Override
	public boolean hasEgunUser(EgunUser user) {
		return false;
	}

	@Override
	public EgunUser getUserByEmail(String email) throws RuntimeException {
		EgunUser user = null;
		try {
//			String getUserByEmailQueryStr = EgunUserQueryBuilder.getUserByEmailQueryStr();
//			Query getUserQuery = getPersistenceManager().newQuery( getUserByEmailQueryStr );
//			getUserQuery.declareParameters(email);
			Query query = getPM().newQuery(getPM().getExtent(EgunUser.class, false));
			query.setFilter("userEmail == \'" + email + "\'");
			query.setResultClass(EgunUser.class);
			List<EgunUser> results = (List<EgunUser>)query.execute();
			
			System.out.println(results.size());
			
			
		} catch (JDOObjectNotFoundException e) {
			throw new RuntimeException(email + "에 해당하는 사용자가 존재하지 않습니다.");
		}
		finally {
			if(!pm.isClosed()) {
				pm.close();
			}
		}
		
		return user;
	}
	
	private PersistenceManager getPM() {
		if (pm == null) {
			pm = pmfInstance.getPersistenceManager();
		}
		return pm;
	}
}