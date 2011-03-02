package com.appspot.egun.money.ws.common;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appspot.egun.money.comp.domain.EgunUser;
import com.appspot.egun.money.comp.process.EgunUserProcess;
import com.appspot.egun.money.comp.utility.JSONResponse;
import com.appspot.egun.money.comp.utility.ResponseBuilder;
import com.appspot.egun.money.comp.utility.SessionManager;
import com.sun.jersey.spi.resource.Singleton;

/**
 * 로그인 Resource
 * @author dongkyu
 * @since 2011.01.25
 */

@Component
@Singleton
@Path("/auth")
public class SignInResource {
	
	@Autowired
	private EgunUserProcess egunUserProcess;
	
	@Context
	private HttpServletRequest request;
	
	@GET
	@Path("/signin")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONResponse signIn(@QueryParam("userEmail") String userEmail, @QueryParam("password") String password) {

		EgunUser foundUser = egunUserProcess.getUserByEmail(userEmail);
		if (foundUser == null) {
			return ResponseBuilder.buildEmptyResponse("아이디 또는 비밀번호가 옳지 않습니다.");
		}
		
		if ( !foundUser.samePassword(password) ) {
			return ResponseBuilder.buildEmptyResponse("아이디 또는 비밀번호가 옳지 않습니다.");
		}
		
		// 로그인 처리
		SessionManager.setLoginUser(request, foundUser);
		
		return ResponseBuilder.buildSuccessResponse(foundUser);
	}
}

