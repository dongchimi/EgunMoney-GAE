package com.appspot.egun.money.app.common;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appspot.egun.money.domain.EgunUser;
import com.appspot.egun.money.service.EgunUserService;
import com.sun.jersey.api.view.Viewable;
import com.sun.jersey.spi.resource.Singleton;

/**
 * 회원가입 Resource
 * @author dongkyu
 * @since 2011.1.25
 */
@Component

@Singleton
@Path("/signup")
@Produces("text/html")
public class SignUpResource {
	
	@Autowired
	private EgunUserService egunUserService;
	
	@GET
	@Path("/form")
	public Viewable viewForm() {
		return new Viewable("signUpForm");
	}
	
	@POST
	@Path("/register")
//	@Consumes("application/x-www-form-urlencoded")
	public Viewable register(@FormParam("user.userEmail") String userEmail,
							  @FormParam("user.password") String password,
							  @FormParam("user.nickName") String nickName) {
		
		EgunUser user = new EgunUser();
		user.setUserEmail(userEmail);
		user.setNickName(nickName);
		user.setPassword(password);
		
		egunUserService.registerUser(user);
		
		return null;
	}
}
