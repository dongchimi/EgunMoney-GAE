package com.appspot.egunmoney.resource;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.appspot.egunmoney.constant.EgunMoneyConstant;

//The Java class will be hosted at the URI path "/myresource"
@Path("/myresource")
@Component
@Scope("request")
public class MyResource {
	
	PersistenceManagerFactory pmfInstance = JDOHelper.getPersistenceManagerFactory(EgunMoneyConstant.PERSISTENCE_MANAGER_FACTORY_NAME);

	/** �ΰ� */
	private static final Logger logger = Logger.getLogger(MyResource.class.getName());
	
	// The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media
    // type "text/plain"
    @Produces("text/plain")
    public String getIt() {
    	if (logger.isLoggable(Level.OFF)) {
    		logger.warning("����� �׽�Ʈ �Դϴ�.");
    	}
    	
    	if (logger.getLevel() == null) {
    		logger.warning("����� ���� ���� ��");
    	} else {
    		logger.warning(logger.getLevel().getName());
    	}

    	// TODO db �׽�Ʈ
    	// PersistenceManager persistenceManager = pmfInstance.getPersistenceManager();
    	
        String nickName = "no nick Name";
        return nickName;
    }
}