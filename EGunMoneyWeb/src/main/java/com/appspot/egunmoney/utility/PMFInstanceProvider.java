package com.appspot.egunmoney.utility;

import javax.jdo.JDOFatalUserException;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import com.appspot.egunmoney.constant.EgunMoneyConstant;

/**
 * PersistenceManagerFactory 인스턴스 제공자
 * @author dongkyu
 */
public class PMFInstanceProvider {
	
	private static PersistenceManagerFactory pmfInstance = null;

	private PMFInstanceProvider() {
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
}
