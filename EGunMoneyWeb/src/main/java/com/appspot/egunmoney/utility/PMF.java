package com.appspot.egunmoney.utility;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import com.appspot.egunmoney.constant.EgunMoneyConstant;

public class PMF {
	
	private static final PersistenceManagerFactory pmfInstance = JDOHelper.getPersistenceManagerFactory(EgunMoneyConstant.PMFN);
	
	private PMF() {}
	
	public static PersistenceManagerFactory getInstance() {
		return pmfInstance;
	}
}
