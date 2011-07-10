package com.appspot.egun.money.comp.service.logic;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jdo.JDOFatalUserException;
import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.springframework.stereotype.Component;

import com.appspot.egun.money.comp.domain.EgunUser;
import com.appspot.egun.money.comp.service.EgunUserService;
import com.appspot.egun.money.comp.utility.PMFProvider;

@Component
public class EgunUserServiceLogic implements EgunUserService {
	
	/** 로거 */
	private static final Logger logger = Logger.getLogger(EgunUserServiceLogic.class.getSimpleName());

	private PersistenceManager pm = null;

	@Override
	public Long registerUser(EgunUser user) {
		pm = PMFProvider.getPersistenceManager();
		try {
			pm.makePersistent(user);
		} catch (JDOFatalUserException e) {
			e.printStackTrace();
		} finally {
			if (!pm.isClosed()) {
				pm.close();
			}
		}
		return user.getOid();
	}

	@Override
	public boolean hasEgunUser(EgunUser user) {
		return false;
	}

	@Override
	@SuppressWarnings("unchecked")
	public EgunUser getUserByEmail(String email) throws RuntimeException {
		EgunUser user = null;

		pm = PMFProvider.getPersistenceManager();

		try {
			Query getUserQuery = pm.newQuery(EgunUser.class, "userEmail == emailParam");
			getUserQuery.declareParameters("String emailParam");

			List<EgunUser> foundUsers = (List<EgunUser>) getUserQuery.execute(email);

			if (!foundUsers.isEmpty()) {
				user = foundUsers.get(0);
			} else {
				logger.log(Level.ALL, "조회한 사용자가 존재하지 않습니다.");
			}
		} catch (JDOObjectNotFoundException e) {
			throw new RuntimeException(email + "에 해당하는 사용자가 존재하지 않습니다.");
		} finally {
			pm.close();
		}

		return user;
	}

	@Override
	@SuppressWarnings("unchecked")
	public EgunUser getUserByNickName(String nickName) throws RuntimeException {
		EgunUser user = null;

		pm = PMFProvider.getPersistenceManager();

		try {
			Query getUserQuery = pm.newQuery(EgunUser.class, "nickName == nickNameParam");
			getUserQuery.declareParameters("String nickNameParam");

			List<EgunUser> foundUsers = (List<EgunUser>) getUserQuery.execute(nickName);

			if (!foundUsers.isEmpty()) {
				user = foundUsers.get(0);
			} else {
				logger.log(Level.ALL, "조회한 사용자가 존재하지 않습니다.");
			}
		} catch (JDOObjectNotFoundException e) {
			throw new RuntimeException(nickName + "에 해당하는 사용자가 존재하지 않습니다.");
		} finally {
			pm.close();
		}

		return user;
	}
}