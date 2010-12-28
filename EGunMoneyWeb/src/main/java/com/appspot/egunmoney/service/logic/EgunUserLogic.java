package com.appspot.egunmoney.service.logic;

import java.util.List;

import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.springframework.stereotype.Component;

import com.appspot.egunmoney.domain.EgunUser;
import com.appspot.egunmoney.service.EgunUserService;
import com.appspot.egunmoney.utility.PMF;

@Component
public class EgunUserLogic implements EgunUserService {
	
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
			
			Query getUserQuery = getPM().newQuery( EgunUser.class, "userEmail == emailParam" );
			getUserQuery.declareParameters("String emailParam");
//			Query query = getPM().newQuery(getPM().getExtent(EgunUser.class, false));
//			query.setFilter("userEmail == emailParam");
			System.out.println("query : " + getUserQuery );
			System.out.println("param : " + email );
			
			List<EgunUser> results = (List<EgunUser>)getUserQuery.execute(email);
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
		pm = PMF.getInstance().getPersistenceManager();
		return pm;
	}
}