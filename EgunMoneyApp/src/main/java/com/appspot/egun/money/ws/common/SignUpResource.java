package com.appspot.egun.money.ws.common;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appspot.egun.money.comp.domain.EgunUser;
import com.appspot.egun.money.comp.service.EgunUserService;
import com.appspot.egun.money.comp.utility.JSONResponse;
import com.appspot.egun.money.comp.utility.ResponseBuilder;
import com.google.appengine.api.datastore.Key;
import com.sun.jersey.spi.resource.Singleton;

/**
 * 회원가입 Resource
 * @author dongkyu
 * @since 2011.1.25
 */
@Component
@Singleton
@Path("/signup")
public class SignUpResource {
	
	@Autowired
	private EgunUserService egunUserService;
	
	@POST
	@Path("/register")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONResponse register(@FormParam("userEmail") String userEmail,
							  @FormParam("password") String password,
							  @FormParam("nickName") String nickName) {
		
		EgunUser user = new EgunUser();
		user.setUserEmail(userEmail);
		user.setNickName(nickName);
		user.setPassword(password);
		
		Key oid = egunUserService.registerUser(user);
		user.setOid(oid);
		
		return ResponseBuilder.buildSuccessResponse(user);
	}
}
