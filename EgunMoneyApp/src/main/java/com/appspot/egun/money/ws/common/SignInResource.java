package com.appspot.egun.money.ws.common;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appspot.egun.money.comp.domain.EgunUser;
import com.appspot.egun.money.comp.process.EgunUserProcess;
import com.appspot.egun.money.comp.utility.JSONResponse;
import com.appspot.egun.money.comp.utility.ResponseBuilder;
import com.appspot.egun.money.comp.utility.SessionManager;
import com.appspot.egun.money.ws.validator.SignInValidator;
import com.sun.jersey.spi.resource.Singleton;

/**
 * �α��� Resource
 * @author dongkyu
 * @since 2011.01.25
 */

@Component
@Singleton
@Path("/ws/auth")
public class SignInResource {
	
	@Autowired
	private EgunUserProcess egunUserProcess;
	
	@Context
	private HttpServletRequest request;
	
	@POST
	@Path("/signin")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONResponse signIn(@FormParam("userEmail") String userNameOrEmail, @FormParam("password") String password) {
		if (SignInValidator.validSigninParams(userNameOrEmail, password)) {
			return ResponseBuilder.buildEmptyResponse("����� �̸� �Ǵ� ��й�ȣ�� �Էµ��� �ʾҽ��ϴ�. userEmail : " + userNameOrEmail + ", " + "password : " + password);
		}
		
		EgunUser foundUser = egunUserProcess.getUserByEmailOrNickName(userNameOrEmail);
		if (foundUser == null) {
			return ResponseBuilder.buildEmptyResponse("����� �̸� �Ǵ� ��й�ȣ�� ���� �ʽ��ϴ�.");
		}
		
		if ( !foundUser.samePassword(password) ) {
			return ResponseBuilder.buildEmptyResponse("����� �̸� �Ǵ� ��й�ȣ�� ���� �ʽ��ϴ�.");
		}
		
		// �α��� ó��
		SessionManager.setLoginUser(request, foundUser);
		
		return ResponseBuilder.buildSuccessResponse(foundUser);
	}
}

