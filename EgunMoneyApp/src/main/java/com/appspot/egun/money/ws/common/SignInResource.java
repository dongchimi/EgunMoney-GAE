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

import com.appspot.egun.money.domain.EgunUser;
import com.appspot.egun.money.service.EgunUserService;
import com.appspot.egun.money.utility.Response;
import com.appspot.egun.money.utility.ResponseBuilder;
import com.appspot.egun.money.utility.SessionManager;
import com.sun.jersey.spi.resource.Singleton;

/**
 * �α��� Resource
 * @author dongkyu
 * @since 2011.01.25
 */

@Component
@Singleton
@Path("/auth")
public class SignInResource {
	
	@Autowired
	private EgunUserService egunUserService;
	
	@Context
	private HttpServletRequest request;
	
	@GET
	@Path("/signin")
	@Produces(MediaType.APPLICATION_JSON)
	public Response signIn(@QueryParam("userEmail") String userEmail, @QueryParam("password") String password) {

		EgunUser foundUser = egunUserService.getUserByEmail(userEmail);
		if (foundUser == null) {
			return ResponseBuilder.buildEmptyResponse("���̵� �Ǵ� ��й�ȣ�� ���� �ʽ��ϴ�.");
		}
		
		if ( !foundUser.samePassword(password) ) {
			return ResponseBuilder.buildEmptyResponse("���̵� �Ǵ� ��й�ȣ�� ���� �ʽ��ϴ�.");
		}
		
		// �α��� ó��
		SessionManager.setLoginUser(request, foundUser);
		
		return ResponseBuilder.buildSuccessResponse(foundUser);
	}
}

