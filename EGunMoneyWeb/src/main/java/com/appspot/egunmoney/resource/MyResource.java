package com.appspot.egunmoney.resource;

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
	
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media
    // type "text/plain"
    @Produces("text/plain")
    public String getIt() {
    	
    	UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();
        
        String nickName = "no nick Name";
        if (user != null) {
            nickName = "Hello, " + user.getNickname();
        }
        return nickName;
    }
}