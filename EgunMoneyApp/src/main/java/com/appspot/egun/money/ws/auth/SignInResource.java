package com.appspot.egun.money.ws.auth;

import java.util.logging.Level;
import java.util.logging.Logger;

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
 * 로그인 Resource
 * 
 * @author dongkyu
 * @since 2011.01.25
 */
@Component
@Singleton
@Path("/ws/auth/signin")
public class SignInResource {

	/** 로거 */
	private static final Logger logger = Logger.getLogger(SignInResource.class.getSimpleName());

	@Autowired
	private EgunUserProcess egunUserProcess;

	@Context
	private HttpServletRequest request;

	@POST
	@Path("/signin")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONResponse signIn(@FormParam("userEmail") String userNameOrEmail, @FormParam("password") String password) {
		if (!SignInValidator.requeredSigninParams(userNameOrEmail, password)) {
			return ResponseBuilder.buildFailResponse("사용자 이름 또는 비밀번호가 입력되지 않았습니다. userEmail : " + userNameOrEmail
					+ ", " + "password : " + password);
		}

		EgunUser foundUser = egunUserProcess.getUserByEmailOrNickName(userNameOrEmail);
		if (foundUser == null) {
			return ResponseBuilder.buildFailResponse("해당하는 사용자가 없습니다.");
		}

		if (!foundUser.samePassword(password)) {
			logger.log(Level.WARNING, "foundUser.getNickName : " + foundUser.getNickName());
			logger.log(Level.WARNING, "foundUser.getPassword : " + foundUser.getPassword());
			logger.log(Level.WARNING, "foundUser.getUserEmail : " + foundUser.getUserEmail());

			return ResponseBuilder.buildFailResponse("비밀번호가 옳지 않습니다.");
		}

		// 로그인 처리
		SessionManager.setLoginUser(request, foundUser);

		return ResponseBuilder.buildSuccessResponse(foundUser);
	}
}
