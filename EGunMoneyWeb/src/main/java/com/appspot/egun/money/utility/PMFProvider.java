package com.appspot.egun.money.utility;

import javax.jdo.JDOFatalUserException;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import com.appspot.egun.money.constant.EgunMoneyConstant;

/**
 * PersistenceManagerFactory 인스턴스 제공자
 * @author dongkyu
 */
public class PMFProvider {
	
	private static PersistenceManagerFactory pmfInstance = null;

	private PMFProvider() {
	}
	
	public static PersistenceManagerFactory get() {
		if (pmfInstance == null) {
			try {
				pmfInstance = JDOHelper.getPersistenceManagerFactory(EgunMoneyConstant.PMFN);
			} catch (JDOFatalUserException e) {
				e.printStackTrace();
			}
		}
		return pmfInstance;
	}
	
	public static PersistenceManager getPersistenceManager() {
		return get().getPersistenceManager();
	}
}
