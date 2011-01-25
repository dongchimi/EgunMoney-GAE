package com.appspot.egun.money.app.common;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appspot.egun.money.domain.EgunUser;
import com.appspot.egun.money.service.EgunUserService;
import com.appspot.egun.money.utility.SessionManager;
import com.sun.jersey.api.view.Viewable;
import com.sun.jersey.spi.resource.Singleton;

/**
 * 로그인 Resource
 * @author dongkyu
 * @since 2011.01.25
 */

@Component
@Singleton
@Path("/auth")
@Produces("text/html")
public class SignInResource {
	
	@Autowired
	private EgunUserService egunUserService;
	
	@Context
	private HttpServletRequest request;
	
	@GET
	@Path("/form")
	public Viewable viewForm() {
		return new Viewable("signin", null);
	}
	
	@GET
	@Path("/signin")
	public Viewable signIn(@QueryParam("user.userEmail") String userEmail, @QueryParam("user.password") String password) {

		EgunUser foundUser = egunUserService.getUserByEmail(userEmail);
		if (foundUser == null) {
			return buildViewable("signin", "입력하신 정보에 해당하는 사용자는 존재하지 않습니다.");
		}
		
		if ( !foundUser.samePassword(password) ) {
			return buildViewable("signin", "입력하신 패스워드가 일치하지 않습니다.");
		} 
		
		// 로그인 처리
		SessionManager.setLoginUser(request, foundUser);

		
		return null;
	}
	
	private Viewable buildViewable(String target, String message) {
		Map<String, String> returnParamMap = new HashMap<String, String>();
		returnParamMap.put("msg", message);
		
		return new Viewable(target, message);
	}
}
