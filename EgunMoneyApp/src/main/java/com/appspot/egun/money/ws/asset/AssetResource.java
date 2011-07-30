package com.appspot.egun.money.ws.asset;


import java.util.logging.Logger;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appspot.egun.money.comp.domain.asset.EgunUserAsset;
import com.appspot.egun.money.comp.process.AssetProcess;
import com.appspot.egun.money.comp.utility.JSONResponse;
import com.appspot.egun.money.comp.utility.ResponseBuilder;
import com.appspot.egun.money.ws.auth.SignInResource;
import com.sun.jersey.spi.resource.Singleton;

/**
 * �α��� Resource
 * 
 * @author dongkyu
 * @since 2011.01.25
 */
@Component
@Singleton
@Path("/ws/asset/asset")
public class AssetResource {

	/** �ΰ� */
	private static final Logger logger = Logger.getLogger(SignInResource.class.getSimpleName());

	@Autowired
	private AssetProcess assetProcess;
	
	@POST
	@Path("/getAssets")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONResponse getAssets(@FormParam("signinId") String signinId) {
		EgunUserAsset foundAsset = assetProcess.getAssetsByUserEmail(signinId);
		return ResponseBuilder.buildSuccessResponse(foundAsset);
	}
//	@POST
//	@Path("/signin")
//	@Produces(MediaType.APPLICATION_JSON)
//	public JSONResponse signIn(@FormParam("userEmail") String userNameOrEmail, @FormParam("password") String password) {
//		if (!SignInValidator.requeredSigninParams(userNameOrEmail, password)) {
//			return ResponseBuilder.buildFailResponse("����� �̸� �Ǵ� ��й�ȣ�� �Էµ��� �ʾҽ��ϴ�. userEmail : " + userNameOrEmail
//					+ ", " + "password : " + password);
//		}
//
//		EgunUser foundUser = egunUserProcess.getUserByEmailOrNickName(userNameOrEmail);
//		if (foundUser == null) {
//			return ResponseBuilder.buildFailResponse("�ش��ϴ� ����ڰ� �����ϴ�.");
//		}
//
//		if (!foundUser.samePassword(password)) {
//			logger.log(Level.WARNING, "foundUser.getNickName : " + foundUser.getNickName());
//			logger.log(Level.WARNING, "foundUser.getPassword : " + foundUser.getPassword());
//			logger.log(Level.WARNING, "foundUser.getUserEmail : " + foundUser.getUserEmail());
//
//			return ResponseBuilder.buildFailResponse("��й�ȣ�� ���� �ʽ��ϴ�.");
//		}
//
//		// �α��� ó��
//		// SessionManager.setLoginUser(request, foundUser);
//
//		return ResponseBuilder.buildSuccessResponse(foundUser);
//	}
}
