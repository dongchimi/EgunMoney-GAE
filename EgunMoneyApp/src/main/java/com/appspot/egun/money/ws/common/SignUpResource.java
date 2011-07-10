package com.appspot.egun.money.ws.common;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appspot.egun.money.comp.domain.EgunUser;
import com.appspot.egun.money.comp.process.EgunUserProcess;
import com.appspot.egun.money.comp.utility.JSONResponse;
import com.appspot.egun.money.comp.utility.ResponseBuilder;
import com.appspot.egun.money.ws.validator.SignUpValidator;
import com.sun.jersey.spi.resource.Singleton;

/**
 * ȸ������ Resource
 * @author dongkyu
 * @since 2011.1.25
 */
@Component
@Singleton
@Path("/ws/signup")
public class SignUpResource
{

    @Autowired
    private EgunUserProcess egunUserProcess;

    @POST
    @Path("/register")
    @Produces(MediaType.APPLICATION_JSON)
    public JSONResponse register( @FormParam("userEmail") String userEmail, @FormParam("password") String password,
                                  @FormParam("nickName") String nickName )
    {
        if ( !SignUpValidator.hasRequiredSingupParams( nickName, userEmail, password ) )
        {
            return ResponseBuilder.buildFailResponse( "ȸ�� ���Կ� �ʿ��� �׸��� �����ϴ�." );
        }

        boolean existUserEmail = egunUserProcess.existEmail( userEmail );
        if ( existUserEmail )
        {
            return ResponseBuilder.buildFailResponse( "�̹� �����ϴ� �̸����Դϴ�." );
        }

        boolean existNickName = egunUserProcess.existNickName( nickName );
        if ( existNickName )
        {
            return ResponseBuilder.buildFailResponse( "�̹� �����ϴ� �̸��Դϴ�." );
        }

        EgunUser user = new EgunUser();
        user.setUserEmail( userEmail );
        user.setNickName( nickName );
        user.setPassword( password );

        Long oid = egunUserProcess.registerUser( user );
        user.setOid( oid );

        return ResponseBuilder.buildSuccessResponse( user );
    }
}
