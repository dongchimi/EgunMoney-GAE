package com.appspot.egun.money.comp.process;

import com.appspot.egun.money.comp.domain.EgunUser;

public interface EgunUserProcess
{
    public Long registerUser( EgunUser user );

    public boolean existEmail( String email );

    public boolean existNickName( String nickName );

    public boolean hasEgunUser( EgunUser user );

    public EgunUser getUserByEmailOrNickName( String email )
        throws RuntimeException;
}