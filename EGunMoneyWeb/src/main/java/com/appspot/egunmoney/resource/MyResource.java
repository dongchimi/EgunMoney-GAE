package com.appspot.egunmoney.resource;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

//The Java class will be hosted at the URI path "/myresource"
@Path("/myresource")
@Component
@Scope("request")
public class MyResource {
	
	/** 로거 */
	private static final Logger logger = Logger.getLogger(MyResource.class.getName());
	
	// The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media
    // type "text/plain"
    @Produces("text/plain")
    public String getIt() {
    	if (logger.isLoggable(Level.OFF)) {
    		logger.warning("디버그 테스트 입니다.");
    	}
    	
    	if (logger.getLevel() == null) {
    		logger.warning("디버그 레벨 이즈 널");
    	} else {
    		logger.warning(logger.getLevel().getName());
    	}

    	UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();
        
        String nickName = "no nick Name";
        if (user != null) {
            nickName = "Hello, " + user.getNickname();
        }
        return nickName;
    }
}